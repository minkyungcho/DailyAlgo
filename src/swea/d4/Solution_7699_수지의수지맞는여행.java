package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {
	
	static int T;
	static int R;
	static int C;
	static int result;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
	
	static Set<Character> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/7699_수지의수지맞는여행.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visit = new boolean[R][C];
			
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			dfs(1-1, 1-1, 1);
			
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		
		result = Math.max(result, cnt);
//		if(cnt==26) {
//			return;
//		}
		
		visit[r][c] = true;
		set.add(map[r][c]);
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C) {
				continue;
			}
			if(visit[nr][nc]==true) {
				continue;
			}
			if(set.contains(map[nr][nc])) {
				continue;
			}
			dfs(nr, nc, cnt+1);
			visit[nr][nc] = false;
			set.remove(map[nr][nc]);
			
		}
		
	}

}
