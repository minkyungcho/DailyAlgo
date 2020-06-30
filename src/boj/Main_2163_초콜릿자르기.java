package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2163_초콜릿자르기 {
	
	static int N, M;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][M+1];
		for (int i = 0; i < N+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i = 1; i < N+1; i++) {
			dp[i][1] = i-1;
		}
		for (int j = 0; j < M+1; j++) {
			dp[1][j] = j-1;
		}
		
		div(N,M);
		
		System.out.println(dp[N][M]);
	}

	private static int div(int x, int y) {
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		int d1 = 0;
		int d2 = 0;
		if(x>=y) {
			d1 = dp[x/2][y];
			d2 = dp[x-x/2][y];
			if(d1<0 && d2<0) {
				return dp[x][y] = div(x/2, y) + div(x-x/2, y) + 1;
			} else if(d1<0) {
				return dp[x][y] = div(x/2, y) + dp[x-x/2][y] + 1;
			} else if(d2<0) {
				return dp[x][y] = dp[x/2][y] + div(x-x/2, y) + 1;
			} else {
				return dp[x][y] = dp[x/2][y] + dp[x-x/2][y] + 1;
			}
		}else {
			d1 = dp[x][y/2];
			d2 = dp[x][y-y/2];
			if(d1<0 && d2<0) {
				return dp[x][y] = div(x, y/2) + div(x, y-y/2) + 1;
			} else if(d1<0) {
				return dp[x][y] = div(x, y/2) + dp[x][y-y/2] + 1;
			} else if(d2<0) {
				return dp[x][y] = dp[x][y/2] + div(x, y-y/2) + 1;
			} else {
				return dp[x][y] = dp[x][y/2] + dp[x][y-y/2] + 1;
			}
		}
		
	}

}
