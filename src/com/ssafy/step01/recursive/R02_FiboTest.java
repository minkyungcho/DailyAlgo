package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R02_FiboTest {
	
	static long[] call1, call2, memo;
	static long totalCnt1, totalCnt2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call1 = new long[N+1];
		call2 = new long[N+1];
		memo = new long[N+1];
		
		
		
		System.out.println(fibo2(N));
		for (int i = 1; i < N+1; i++) {
			System.out.println("fibo2("+i+") : "+call2[i]);
		}
		System.out.println("fibo2 call count : "+totalCnt2);
		System.out.println("===================================");
		System.out.println(fibo(N));
		for (int i = 1; i < N+1; i++) {
			System.out.println("fibo("+i+") : "+call1[i]);
		}
		System.out.println("fibo call count : "+totalCnt1);
		
	}
	
	// 1, 1, 2, 3, 5, 8 ...
	private static long fibo(int n) {
		++call1[n];
		++totalCnt1;
		if(n<=1) return n;
		
		return fibo(n-1) + fibo(n-2);
	}

	private static long fibo2(int n) {
		++call2[n];
		++totalCnt2;
		if(n<=1) return n;
		
		if(memo[n] != 0) return memo[n];
		
		return memo[n] = fibo2(n-1) + fibo2(n-2);
	}

}
