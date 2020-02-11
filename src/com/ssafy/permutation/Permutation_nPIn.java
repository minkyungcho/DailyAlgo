package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPIn {
	
	static int N; 			// 원소 수
	static int[] numbers; 	// 순열을 담을 배열
	static int testcase; 	// 순열의 수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		permutation(0); // 
		System.out.printf("중복 순열 %dㅠ%d의 개수 : %d", N, N, testcase);
		
	}
	
	/**
	 * 순열을 만들 함수
	 * cnt : 배열의 index
	 */
	private static void permutation(int cnt) {
		
		if(cnt == N) { // cnt가 N이라는 것은 원소를 N개만큼 다 뽑은것.
			testcase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

}
