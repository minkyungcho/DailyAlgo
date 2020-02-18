package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_T {

	static int rowN;
	static int colN;
	static int scol;
	static int srow;
	static int ecol;
	static int erow;
	static int[][] map;
	static int[][] visit;
	static int result=Integer.MAX_VALUE;
	static int cnt;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/bank/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];
		visit = new int[rowN][colN];

		// 배열 선언시 => 좌표 1~N 보정
		st = new StringTokenizer(br.readLine().trim(), " ");
		scol = Integer.parseInt(st.nextToken())-1;
		srow = Integer.parseInt(st.nextToken())-1;
		ecol = Integer.parseInt(st.nextToken())-1;
		erow = Integer.parseInt(st.nextToken())-1;
		
		
		// 공백 x => charAt()-'0'
		// map에 미로 입력
		String str;
		for (int i = 0; i < rowN; i++) {
			str = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// bfs
		// 시작 좌표가 주어져있기 때문에 bfs할때 매개변수 필요 없음.
		bfs();
		
		System.out.println(map[erow][ecol]-1);
//		System.out.println(Y + X + x1 + x2 + y1 + y2);
	}

	private static void bfs() {
		
		LinkedList<int[]> q = new LinkedList<>();

		// 1. 시작점 방분표시 1, 큐에 넣기
		map[srow][scol] = 1;
		q.offer(new int[] {srow, scol});
		
		int nr, nc, t, r, c;
		int[] temp;
		
		// 2. 큐가 empty가 아닐때까지 반복
		while(!q.isEmpty()) {
			// 2.1 큐에서 데이타 추출. r, c, t
			temp = q.poll();
			r = temp[0];
			c = temp[1];
			t = map[r][c];
		
			// 2.2 인접 처리 => 4방향 탐색
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				
				// 2.3 경계 검사, 갈 수 있는 길인지 map[nr][nc]==0, <= 방문검사까지 함.
				if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc]==0) {
					
					map[nr][nc] = t+1; // 방문 표시, 시간 기록
					
					// 2.3.1 갈 수 있다면, nr nc가 도착인지 확인 
					if(nr==erow && nc==ecol) {
						// 2.3.1.1 도착했으면 return / break 2;
						return;
					}else {
						// 2.3.2 갈 수 없다면 새로운 nr, nc를 큐에 넣는다.
						q.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}
}
