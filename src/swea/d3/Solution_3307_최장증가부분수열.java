package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int maxCnt = 0;
			// 1 6 2 3 4
			for (int i = 0; i < N; i++) {
				dp[i] = 1; // arr[i]로 끝나는 가장 긴 부분 수열의 길이
				// 마지막으로 뽑은 수가 arr[i] 일때 가장 긴 부분 수열의 길이 
				// 지금까지 만들어 놓은 증가수열에 arr[i]를 붙일 수 있으려면
				// 만들어놓은 증가수열이 arr[i] 보다 앞에 있어야 하고 : j<i
				// 마지막 수가 arr[i]보다 작아야 한다. : arr[j]<arr[i]
				// O(N^2)
				for (int j = 0; j < i; j++) {
					if(arr[i] > arr[j]) { 
						// i==3 -> arr[3]=3 로 끝나는 가장 긴 부분수열은 
						// 1 2 처럼 3보다 작은 값으로 끝나는 수열에 3만 붙여주면 되는것.
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
				maxCnt = Math.max(maxCnt, dp[i]);
			}
			
			sb.append("#"+tc+" "+maxCnt+"\n");
		}
		System.out.print(sb);
	}

}
/*
3
5
1 3 2 5 4 
6
4 2 3 1 5 6
5
1 6 2 3 4
 */
