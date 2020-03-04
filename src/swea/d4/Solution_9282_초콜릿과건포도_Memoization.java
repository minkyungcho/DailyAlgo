package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도_Memoization {

	static int result;
	static int n, m;
	static int[][] map;
//	static int[][] map;
	static int[][][][] dp;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/9282_초콜릿과건포도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t < TC+1; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			dp = new int[n+1][m+1][n+1][m+1];
			for (int[][][] d1: dp){
				for (int[][] d2: d1){
					for (int[] d3: d2){
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 사이즈 정해져 있으
			// 처리
			result = dfs(0,0,n,m);
			
			// 출력 
			System.out.println("#"+t+" "+result);
		}
	}

	private static int dfs(int y, int x, int h, int w) {
		// 종료 
		if(w==1 && h==1) { // 단일조각일때는 종료 
			return 0;
		}
		
		if(dp[y][x][h][w]!=Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
		
		// 실행 
		// 기존에 있던 덩어리의 건포도의 개수 
		int sum = 0;
		for (int i = y; i < y+h; i++) {
			for (int j = x; j < x+w; j++) {
				sum += map[i][j];
			}
		}
		
		// 재귀호출 
		// 가로로 나누어서 비용을(최소비용) 구한다.
		for (int i = 1; i < h; i++) {
			// 위쪽에 대한 비용
			if(dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y,x,i,w);
			}
//			dp[y][x][i][w] = dfs(y, x, i, w);
//			int sum1 = dfs(y, x, i, w);
			
			// 아래쪽에 대한 비용
			if(dp[y+i][x][h-i][w] == Integer.MAX_VALUE) {
				dp[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
			}
//			int sum2 = dfs(y+i, x, h-i, w);
//			dp[y+i][x][h-i][w] = dfs(y+i, x, h-i, w);
			
			int sum3 = sum + dp[y][x][i][w] + dp[y+i][x][h-i][w];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		// 세로로 나누어서 비용을(최소비용) 구한다.
		for (int i = 1; i < w; i++) {
			// 왼쪽에 대한 비용
			if(dp[y][x][h][i] == Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y,x,h,i);
			}
//			int sum1 = dfs(y, x, h, i);
			// 오른쪽에 대한 비용
			if(dp[y][x+i][h][w-i] == Integer.MAX_VALUE) {
				dp[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
			}
//			int sum2 = dfs(y, x+i, h, w-i);
//			int sum3 = sum + sum1 + sum2;
			int sum3 = sum + dp[y][x][h][i] + dp[y][x+i][h][w-i];
			
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		System.out.println(dp[y][x][h][w]);
		return dp[y][x][h][w];
	}

}
