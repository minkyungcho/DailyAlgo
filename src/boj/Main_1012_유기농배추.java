package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	
	static int T;
	static int N;
	static int M;
	static int K;
	static int result;
	static int[][] map;
	static boolean[][] visit;
	// right down left up
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/1012_유기농배추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			
			int n, m;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				m = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				map[n][m] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 배추가 심어져있으면서 방문하지 않았으면 dfs
					if(map[i][j]==1 && !visit[i][j]) {
						dfs(i, j);
						result++;
					}
				}
			}
			
//			print();
			
			System.out.println(result);
		}
	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc]==1 && !visit[nr][nc]) {
				dfs(nr, nc);
			}
			
			
		}
		
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}