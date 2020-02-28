package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1227_미로2 {
	
	static int result;
	static int T = 10;
	static char[][] map;
	static boolean[][] visit;
	static int sr;
	static int sc;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1227_미로2_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			br.readLine();

			result = 0;
			map = new char[100][100];
			visit = new boolean[100][100];
			
			String str;
			char n;
			for (int i = 0; i < 100; i++) {
				str = br.readLine();
				for (int j = 0; j < 100; j++) {
					n = str.charAt(j);
					map[i][j] = n;
					if(map[i][j]=='2') {
						sr = i;
						sc = j;
					}
				}
			}
			dfs2(sr, sc);
		
			System.out.println("#"+testcase+" "+result);
		}
	}

	private static void dfs2(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(nr>-1 && nc>-1 && nr<100 && nc<100 ) {
				if(map[nr][nc]=='3') {
					result = 1;
					return;
				}else if(map[nr][nc]=='0' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = '2';
					dfs2(nr, nc);
				}
			}
		}
	}

}
