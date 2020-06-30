package com.ssafy.monthlyTest;

import java.util.Scanner;

/**
 * 월말평가 소금배달 문제 2
 * Backtracking 
 */
public class 소금배달2 {

	static int min = Integer.MAX_VALUE; // 최소봉지 개수 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		go(M, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
	}
	
	/**
	 * 
	 * @param M		: 남은 무게 
	 * @param cnt	: 지금까지 사용한 봉지 개수 
	 */
	public static void go(int M, int cnt) {
		if(M < 0) { // 	해가 없다 
			return;
		}else if(M == 0) { // 해 
			if(min < cnt) {
				min = cnt;
			}
		}else {
			go(M-5, cnt+1);
			go(M-3, cnt+1);
		}
		
	}

}
