package com.ssafy.recursive;

/**
 * 1 2 3 4 5 6 7 8 9 10 11 12 
 * 1 1 2 3 5 8 13 21 34 55 89 ...
 */
public class RecursiveCallFibo {

	/**
	 * 피보나치 수열을 출력하고 수열의 합을 리턴하는 기능
	 * n : n번째 수열
	 * return : n번째 수열까지의 합 
	 */
	public static int fibo1(int n) {
		int sum = 0; 
		int old = 0;	// n-2
		int su = 1;		// n-1
		int newsu = 0;	// n
	
		for(int i=1; i<=n; i++) {
			System.out.println(su+" ");
			sum += su;
			newsu = old+su;
			old = su;
			su = newsu;
		}
		return sum;
	}
	
	public static int fibo2(int n) {
		if(n<2) {
			return n;
		}
		return fibo2(n-1)+fibo2(n-2);
	}
	
	public static int fibo3(int n, int old, int su) {
		if(n==1) {
			System.out.print(su+" ");
			return su;
		}
		
		System.out.print(su+" ");
		return su+fibo3(--n, su, old+su);
	}
	
	public static void main(String[] args) {
		int n = 7;
		System.out.printf("%d번째의 수열과 합: %d\n", n, fibo1(n));
		System.out.printf("%d번째의 수열: %d\n", n, fibo2(n));
		System.out.printf("%d번째의 수열의 합: %d\n", n, fibo3(n, 0, 1));
	}

}
