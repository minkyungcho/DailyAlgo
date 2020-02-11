package com.ssafy.recursive;

public class RecursiveCallFactorial {
	
	static int N = 7;
	
	public static int Fac2(int n) {
		if(n == N) {
			return n;
		}
		return n*Fac2(n+1);
	}
	
	public static int Fac(int n) {
		if(n==1) {
			return 1;
		}
		return n*Fac(n-1);
	}
	
	public static void main(String[] args) {
		
		int n = 7;
		int fac = 1;
		
		for(int i=2; i<n+1; i++) {
			fac *= i;
			System.out.printf("%d! : %d\n", i, fac);
			System.out.printf("%d! : %d\n", i, Fac(i));
		}
		
		System.out.println(Fac(n));
		System.out.println(Fac2(1));
	}

}
