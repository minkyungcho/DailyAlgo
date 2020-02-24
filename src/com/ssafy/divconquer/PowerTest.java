package com.ssafy.divconquer;

public class PowerTest {

	public static long powerRec(int x, int n){
		long p = x;
		for (int i = 1; i < n; i++) {
			p *= x;
		}
		return p;
	}

	public static long dcPower(int x, int n){
		if(n==1) {
			return x;
		}
		if(n==0) {
			return 1;
		}
		long ret = dcPower(x, n>>1);
		if(n%2==0) {
			return ret*ret;
		}else {
			return ret*ret*x;
		}
	}

//	public static long powerRec(int x, int n){
//		if(n==1) {
//			return x;
//		}
//		if(n==0) {
//			return 1;
//		}
//		return x * powerRec(x,n-1);
//	}
	
	public static void main(String[] args) {
		
//		System.out.println(powerRec(9, 2111111));
		long stime = System.currentTimeMillis();
//		System.out.println(powerRec(2, 622222222));
		System.out.println(dcPower(2,10));
		long etime = System.currentTimeMillis();
		System.out.printf("%dms", etime-stime);
		
		
	}

}
