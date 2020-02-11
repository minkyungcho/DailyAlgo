package com.ssafy.recursive;

public class RecursiveCallSum {
	
	static int N = 10;
	
	public static int sum(int n) {
		if(n == 1) {
			return 1;
		}
		return n+sum(n-1);
	}
	
	public static int sum2(int n) {
		if(n==N) {
			return n;
		}
		return n+sum2(n+1);
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		int sum = 0;
		
		for(int i=1; i<n+1; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(sum(n));
		System.out.println(sum2(1));
	}

}
