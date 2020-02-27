package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1211_Ladder2_fail {
	
	static int T = 10;
	static int t;
	static int min=Integer.MAX_VALUE;
	static int result;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visit;

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 } };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1211_Ladder2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testcase = 1; testcase < T + 1; testcase++) {
			map = new int[100][100];
//			copymap = new int[100][100];
			t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken());
//					copymap[i][j] = n;
				}
			}
			System.out.println("input end");
			for (int i = 0; i < 100; i++) {
				if(map[0][i]==1) {
					result = 0;
					dfs(0,i);
					System.out.println(i+" "+result);
				}
			}
			
			System.out.println("#"+t+" "+min);
			return;
		}
	}

	private static void dfs(int r, int c) {
		
//		System.out.println("dfs");
		
//		int nr, nc;
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr>-1 && nc>-1 && nr<100 && nc<100 && map[nr][nc]==1) {
				result++;
				dfs(nr, nc);
				break;
			}
		}
		
		if(r==99) {
			if(min>=result) {
				min = result;
			}
//			return;
		}
	}
	private static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
