package com.ssafy.step02.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P01_BooleanArrayTest {

	static int N, R;
	static int[] input, number;
	static boolean[] isSelected;
	static int totalCnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// N개 중에서 R개 뽑자.
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
		System.out.println("총 경우의 수 : "+totalCnt);
		/*
		 * 	3 2
		 * 	1 2 3
		 * 	-----
		 * 	[1, 2]
			[1, 3]
			[2, 1]
			[2, 3]
			[3, 1]
			[3, 2]
			총 경우의 수 : 6
			
			3 3
			1 2 3
			------
			[1, 2, 3]
			[1, 3, 2]
			[2, 1, 3]
			[2, 3, 1]
			[3, 1, 2]
			[3, 2, 1]
			총 경우의 수 : 6
 		 */
	}
	
	private static void permutation(int cnt) { // cnt : 순열을 뽑는 자리 
		
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도(앞자리까지 선택된 수 배제)
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			number[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1); // 다음자리의 순열 뽑기 
			isSelected[i] = false;
		}
		
	}
	
}
