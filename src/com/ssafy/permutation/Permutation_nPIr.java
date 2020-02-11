package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPIr {
	
	static int N; 			// 원소 수
	static int R; 			// 추출할 원소 수
	static int[] numbers; 	// 순열을 담을 배열
	static int testcase; 	// 순열의 수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R]; // R개를 뽑을거니까 R크기의 배열 선언
		permutation(0); // 
		System.out.printf("중복 순열 %dㅠ%d의 개수 : %d", N, R, testcase);
		
	}
	
	/**
	 * 순열을 만들 함수
	 * cnt : 배열의 index
	 */
	private static void permutation(int cnt) {
		
		// R 만큼만 뽑으면 된다!
		if(cnt == R) { // 원소를  R개 만큼만 추출
			testcase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<N+1; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

}
