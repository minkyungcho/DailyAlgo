package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_T {
	
	// queue에 넣을 객체의 좌표 값과, 벽돌이 깨질 때 범위 
	static class Brick{
		int row, col, pow;
		
		public Brick(int row, int col, int pow){
			this.row = row;
			this.col = col;
			this.pow = pow;
		}

		@Override
		public String toString() {
			return "[" + row + ", " + col + ", "+ pow + "]";
		}
		
	}
	
	static Queue<Brick> q;
	
	static int T;
	static int N;
	static int R;
	static int C;
	static int[][] map;
	static int[] sets;
	static boolean[][] visited;
	static int ans;
	static int brickCnt;
	
	// up down left right
	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/5656_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testcase = 1; testcase < T + 1; testcase++) {
			brickCnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 구슬 
			C = Integer.parseInt(st.nextToken());	// 열  
			R = Integer.parseInt(st.nextToken());	// 행 
			
			q = new LinkedList<>();
			sets = new int[N];
			map = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						brickCnt++;
					}
				}
			}
			ans = brickCnt;
			dropMarble(N, brickCnt, map);
			
//			print();
			System.out.println("#" + testcase + " "+ans);
			
//			return;
		}
	}


	private static void dropMarble(int r, int brickCnt, int[][] map) {
		if(r==0) {
			// 솔루션 사용 
			ans = Math.min(ans, brickCnt);
			return;
		}
		for (int c = 0; c < C; c++) {
			// 1. map의 복제
			int[][] cloned = cloneMap(map);
			// 2. 해당 컬럼의 맨 처음 벽돌 가져오기 
			Brick first = getFirstBrick(c, cloned);
			// 2-1 null --> continue
			if(first==null) {
				continue;
			}
			// 3. 구슬을 떨어뜨려서 벽돌을 깬다. --> 깨진 벽돌 개수?? 
			int broken = crash(first, cloned);
			// 3-1 이미 다 벽돌이 깨졌다면? 정답=0, 종료 
			if(broken >= brickCnt) {
				ans = 0;
				return;
			}
			// 4. 화면 정리 
			cleanMap(cloned);
			// 5. 다음 구슬 발사!! 
			dropMarble(r-1, brickCnt-broken, cloned);
		}
	}


	private static void cleanMap(int[][] map) {
		for (int c = 0; c < C; c++) {
			for (int r = R-1, nr = R-1; r >= 0; r--) {
				if(map[r][c]!=0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[nr--][c] = temp;
				}
			}
		}
		
		
	}


	private static int crash(Brick first, int[][] map) {
		int broken = 0;
		// 얻어맞은 벽돌 삭제 
		map[first.row][first.col] = 0;
		broken++;
		
		// 주변 벽돌에 영향 주기 
		for (int p = 1; p < first.pow; p++) {
			// 사방 탐색 
			for (int d = 0; d < 4; d++) {
				int nr = first.row + dir[d][0]*p;
				int nc = first.col + dir[d][1]*p;
				if(isIn(nr, nc) && map[nr][nc]!=0) {
					broken += crash(new Brick(nr, nc, map[nr][nc]), map);
				}
			}
			
		}
		return broken;
	}


	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<R && c<C;
	}


	private static Brick getFirstBrick(int c, int[][] map) {
		for (int r = 0; r < R; r++) {
			if(map[r][c]!=0) {
				return new Brick(r, c, map[r][c]);
			}
		}
		return null;
	}


	private static int[][] cloneMap(int[][] map) {
		int[][] temp = new int[R][C];
		for (int r = 0; r < R; r++) {
			temp[r] = map[r].clone();
		}
		return temp;
	}
	
}
