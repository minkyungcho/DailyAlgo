package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636_치즈_T {
	
	static int N, M;		// 행렬 
	static int[][] cheese;	// 치즈판  0:방문하지 않은 공기  1:치즈   -1:방문한공기   2:녹을치즈
	static int last;		// 마지막 남은 치즈 개수 
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		// 치즈가 없을때까지 공기를 중심으로 탐색
		do {
			dfs(0,0);		// 공기의 첫좌표 
			time++;
		}while(cheeseCheck());
		// 치즈가 있는지 체크 
		
		System.out.println(time-1);
		System.out.println(last);
	}

	private static boolean cheeseCheck() {
		int count = 0;
		
		// 전체 치즈판을 탐색하면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cheese[i][j] == 1) continue;
				// 녹을 치즈 2 이면 count 센 후에 녹여준다. => 0으로 바꾼다. 
				if(cheese[i][j] == 2) {
					count++;
				}
				// 녹을 치즈와 방문한 공기(-1)면 다시 탐색하기 위해서 0으로 바꾼다.
				cheese[i][j] = 0;
			}
		}
		if(count==0) {
			return false;
		}else {
			last = count;
			return true;
		}
	}

	private static void dfs(int r, int c) {
		cheese[r][c] = -1; // 공기에 대한 방문 처리 
		int nr, nc;
		
		// 공기를 중심으로 사방에 치즈가 있는지 검사 
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(-1<nr&&nr<N &&-1<nc&&nc<M) {
				// 치즈면 -> 공기옆 치즈는 녹을 치즈 표시 2
				if(cheese[nr][nc]==1) {
					cheese[nr][nc] = 2;
				}else if(cheese[nr][nc]==0) {
					// 공기면 -> 계속 탐색 
					dfs(nr, nc);
				}
			}
		}
		
	}

}
