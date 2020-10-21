package top.DynamicProgramming;

import java.util.Arrays;

public class P04LongestIncreasingSubsequence {

	public static void main(String[] args) {

		P04LongestIncreasingSubsequence a = new P04LongestIncreasingSubsequence();
//		int[] nums = {1,2,3,2,5,2,6,10,4,12};
		int[] nums = {9,11,2,8,4,7,88,15};
		
		System.out.println(a.solve(nums));
		
	}
	
	public static int solve(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		
		// 1.
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		int result = 1;
		
		// 2.
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}

}
