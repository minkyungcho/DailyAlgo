package com.ssafy.dp;

import java.util.Scanner;

public class 연습문제3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] memo = new int[N+1];
		// f(n) = f(n-1) + f(n-2) + f(n-3)
//		memo[1] = 1;
//		memo[2] = 2;
//		memo[3] = 4;
//		
//		for (int i = 4; i <=N ; i++) {
//			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
//		}
		
		
		// f(n) = 2*f(n-1) - f(n-4)
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		memo[4] = 7;
		
		for (int i = 5; i <=N ; i++) {
			memo[i] = 2*memo[i-1] - memo[i-4];
		}
		System.out.println("f(8) = "+memo[N]);
	}

}
