package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1868_파핑파핑지뢰찾기 {
	
	static int T;
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int result;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1868_파핑파핑지뢰찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			result = 0;
			
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
			
			// 지뢰 개수로 map 채우기 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						setNum(i, j);
					}
				}
			}
			
			// map에 0인 애들 찾아서 그 주변까지 탐색 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='0' && !visit[i][j]) {
						check(i, j);
						result++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						result++;
					}
				}
			}
			
//			print();
//			System.out.println();
			
			
			System.out.println("#"+testcase+" "+result);
			
		}
	}
	
	private static void check(int r, int c) {
		
		visit[r][c] = true;
		for (int d = 0; d < 8; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr>-1 && nc>-1 && nr<N && nc<N) {
				if(map[nr][nc]=='0' && !visit[nr][nc]) {
					check(nr, nc);
				}
				visit[nr][nc] = true;
			}
		}
		
	}

	private static void setNum(int r, int c) {
		char cnt = '0';
		for (int d = 0; d < 8; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr<0 || nc<0 || nr>N-1 || nc>N-1) {
				continue;
			}
			if(map[nr][nc]=='*') {
				cnt++;
			}
		}
		if(cnt!=0) {
			map[r][c] = cnt;
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}

	}
}
