package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d9_1949_등산로조성 {

	static int[][] map;
	static boolean[][] visit;
	static int N, K;
	static int high;
	static int max;
	
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d9/1949_등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			high = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					high = Math.max(high, map[i][j]);
				}
			}
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==high) dfs(i, j, 1, false);
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void dfs(int i, int j, int cnt, boolean use) {
		max = Math.max(max, cnt);
		visit[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !visit[ni][nj]) {
				if(map[ni][nj]<map[i][j]) { // 내리막길인 경우 
					dfs(ni, nj, cnt+1, use);
				}else { // 내리막길이 아닌 경우 
					if(!use) { // 한번도 깎은적이 없다면 
						for (int k = 1; k <= K; k++) {
							if(map[ni][nj]-k < map[i][j]) { // 깎았을때 내리막길인 경우 
								map[ni][nj] -= k;
								dfs(ni, nj, cnt+1, true); // 한번 깎았으면 또 못깎아, true로 변경!!
								map[ni][nj] += k; // 깎은거 다시 원상복귀 
							}
						}
					}
				}
			}
		}
		visit[i][j] = false; // 방문처리 원상복귀 
	}

}
