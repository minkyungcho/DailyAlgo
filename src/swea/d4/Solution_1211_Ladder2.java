package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1211_Ladder2 {
	
	static int T = 10;
	static int t;
	static int min;
	static int result;
	static int resultIdx;
	static int resultA;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visit;
	static int nr;
	static int nc;
	
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 } };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1211_Ladder2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int tc = 1; tc < T+1; tc++) {
			t = Integer.parseInt(br.readLine());
			map = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 && map[i][j]==1) {
						arr.add(j);
					}
				}
			}
			
			min=Integer.MAX_VALUE;
			for(int a : arr) {
				result = 0;
				visit = new boolean[100][100];
				resultA = a;
				dfs(0,a);
			}
			System.out.println("#"+t+" "+resultIdx);
		}
		
	}

	private static void dfs(int r, int c) {
		result++;
		
		if(r==99) {
			if(min>result) {
				min = result;
				resultIdx = resultA;
			}
			return;
		}
			
		visit[r][c] = true;
		for (int d = 0; d < 3; d++) {
			nr = r + dir[d][0]; 
			nc = c + dir[d][1];
			if(nr>-1 && nc>-1 && nr<100 && nc<100 && map[nr][nc]==1 && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc);
				break;
			}
		}
		
	}
}
