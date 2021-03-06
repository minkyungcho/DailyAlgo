package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행2 {

	static int R, C;
	static int[][] map;
	static int maxCnt; // 최대로 볼 수 있는 명물 개수
	
	static int[] visit;
	static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d5/7699_수지의수지맞는여행.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[R][C];
			visit = new int[26+1];
			maxCnt = 0;
			for (int r = 0; r < R; r++) {
				String str = br.readLine();
				for (int c = 0; c < C; c++) {
					map[r][c] = str.charAt(c) - 'A';
				}
			}
			
			// dfs
			dfs(1-1, 1-1, 1);
			
			System.out.println("#"+tc+" "+maxCnt);
		}

	}

	static void dfs(int row, int col, int cnt) {
		// 종료 
		maxCnt = Math.max(maxCnt, cnt);
		if(cnt == 26) {
			return;
		}
		// 실행 & 재귀호출 
		visit[map[row][col]] = 1;
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = row + dir[d][0];
			nc = col + dir[d][1];
			if(isIn(nr,nc) && visit[map[nr][nc]]!=1) {
				// 재귀호출 
				dfs(nr, nc, cnt+1);
				visit[map[nr][nc]] = 0;
			}
		}
		
	}
	static boolean isIn(int row, int col) {
		return 0<=row&&row<R && 0<=col&&col<C;
	}

}
