package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][10];
		
		// 1의 자리의 계단수 
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 2의 자리부터의 계단수 
		for (int i = 2; i < N+1; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
				}else if(j==9) {
					dp[i][j] = dp[i-1][j-1] % 1000000000;
				}else {
					dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum % 1000000000);
	}

}
