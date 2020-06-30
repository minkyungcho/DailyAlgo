package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_6109_추억의2048게임 {
	
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static String cmd;
	
	static int[] di = {-1, 1, 0, 0}; // 상0, 하1, 좌2, 우3 
	static int[] dj = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/6109_추억의2048게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			cmd = st.nextToken();
			map = new int[N][N];
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			switch(cmd) {
			case "up": // 상 0
				for (int j = 0; j < N; j++) {
					for (int i = 1; i < N; i++) {
						move(i, j, 0);
					}
				}
				break;
			case "down": // 하 1
				for (int j = 0; j < N; j++) {
					for (int i = N-2; i >= 0; i--) {
						move(i, j, 1);
					}
				}
				break;
			case "left": // 좌 2
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						move(i, j, 2);
					}
				}
				break;
			case "right": // 우 3
				for (int i = 0; i < N; i++) {
					for (int j = N-2; j >= 0; j--) {
						move(i, j, 3);
					}
				}
				break;
			}
			
			System.out.println("#"+tc);
			printMap();
		}
	}

	private static void move(int i, int j, int d) {
		int ni = i + di[d];
		int nj = j + dj[d];
		if(0<=ni&&ni<N && 0<=nj&&nj<N && !visit[ni][nj]) {
			if(map[i][j]!=0 && map[i][j]==map[ni][nj] && !visit[i][j]) {
				map[ni][nj] = map[i][j]*2;
				map[i][j] = 0;
				visit[ni][nj] = true;
			}else if(map[ni][nj]==0) {
				map[ni][nj] = map[i][j];
				map[i][j] = 0;
			}
			move(ni,nj,d);
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}


