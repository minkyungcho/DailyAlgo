package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1810_백설공주_조민경 {

	static int testcase;
	static int r;
	static int[] numbers; // 조합을 담을 배열
	static int[] mans;
	
	public static void main(String[] args) {
		
		mans = new int[9];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			mans[i] = sc.nextInt();
		}
		r = 7;
		numbers = new int[r];
		
		combination(0, 0);
		
	}
	/**
	 * 조합을 구하는 함수
	 * @param cnt	배열의 index
	 * @param start	조합을 시작할 수
	 */
	private static void combination(int cnt, int start) {
		
		if(cnt == r) {
			int sum = 0;
			for(int num : numbers) {
				sum += num;
			}
			if(sum == 100) {
				for(int num : numbers) {
					System.out.println(num);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			numbers[cnt] = mans[i];
			combination(cnt+1, i+1);
		}
		
	}

}
