package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			dp[i] = i;
		}
		
		for (int i = 2; i < N+1; i++) {
			for (int j = 2; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);

	}

}
