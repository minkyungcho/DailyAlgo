package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도_Me {

	static int result;
	static int R, C;
	static int[][] map;
	static int[][][][] dp;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/9282_초콜릿과건포도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t= 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			dp = new int[R+1][C+1][R+1][C+1];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int[][][] d1 : dp) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			
			result = dfs(0, 0, R, C);
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static int dfs(int r, int c, int h, int w) {
		// finish 
		if(h==1 && w==1) {
			return 0;
		}
		
		// memoization
		if(dp[r][c][h][w]!=Integer.MAX_VALUE) {
			return dp[r][c][h][w];
		}
		
		// sum
		int sum = 0;
		for (int i = r; i < r+h; i++) {
			for (int j = c; j < c+w; j++) {
				sum += map[i][j];
			}
		}
		
		// cut width
		for (int i = 1; i < h; i++) {
			// up
			if(dp[r][c][i][w]==Integer.MAX_VALUE) {
				dp[r][c][i][w] = dfs(r,c,i,w);
			}
			
			// down
			if(dp[r+i][c][h-i][w]==Integer.MAX_VALUE) {
				dp[r+i][c][h-i][w] = dfs(r+i,c,h-i,w);
			}

			// sum
			int sum2 = sum + dp[r][c][i][w] + dp[r+i][c][h-i][w];
			dp[r][c][h][w] = Math.min(sum2, dp[r][c][h][w]); 
		}

		// cut height
		for (int i = 1; i < w; i++) {
			// left
			if(dp[r][c][h][i]==Integer.MAX_VALUE) {
				dp[r][c][h][i] = dfs(r,c,h,i);
			}
			
			// right
			if(dp[r][c+i][h][w-i]==Integer.MAX_VALUE) {
				dp[r][c+i][h][w-i] = dfs(r,c+i,h,w-i);
			}
			
			// sum
			int sum2 = sum + dp[r][c][h][i] + dp[r][c+i][h][w-i];
			dp[r][c][h][w] = Math.min(sum2, dp[r][c][h][w]); 
		}
		
		return dp[r][c][h][w];
	}

}
