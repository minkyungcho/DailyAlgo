package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기_new {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j = 4; j < 12; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb);
	}

}
