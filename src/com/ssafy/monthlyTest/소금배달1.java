package com.ssafy.monthlyTest;

import java.util.Scanner;

/**
 * 월말평가 소금배달 문제 1
 * Greedy 
 */
public class 소금배달1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		// 3kg, 5kg
//		int cnt = M / 5 + (M%5)/3; // 가설이 틀림
		int cnt = 0;
		// 21kg : 5 5 5 3 3
		while(M%5 != 0) { // 5로 나누어 떨어지지 않는다면 
			M -= 3;
			cnt++;
			
		}
		if(M < 0) {
			System.out.println("-1");
		}else {
			cnt += M/5;
			System.out.println(cnt);
		}
	}

}
