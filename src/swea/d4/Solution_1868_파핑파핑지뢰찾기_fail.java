package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1868_파핑파핑지뢰찾기_fail {
	
	static int T;
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int result;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1868_파핑파핑지뢰찾기_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			
			String str;
			char tmp;
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					tmp = str.charAt(j);
					map[i][j] = tmp;
					if(tmp=='*') {
						visit[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.' && !visit[i][j]) {
						dfs(i, j);
						print();
						System.out.println();
					}
				}
			}
			
			
			
			System.out.println("#"+testcase+" "+result);
			
		}
	}
	
	private static void dfs(int r, int c) {
		char cnt = '0';
		for (int d = 0; d < 8; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(nr>-1 && nc>-1 && nr<N && nc<N) {
				if(map[nr][nc]=='*') {
					cnt++;
				}
			}
		}
		map[r][c] = cnt;
		
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
