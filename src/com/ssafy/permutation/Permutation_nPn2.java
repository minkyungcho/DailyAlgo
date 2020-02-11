package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPn2 {
	
	static int N; 			// 원소 수
	static int[] numbers; 	// 순열을 담을 배열
	static int testcase; 	// 순열의 수
	static boolean[] selected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long start = System.currentTimeMillis();
		numbers = new int[N]; 
		selected = new boolean[N+1]; // 0을 안쓰고 1부터 쓸 것이다. 배열의 index가 원소의 값
		permutation(0); //
		long end = System.currentTimeMillis();
		System.out.printf("순열 %dP%d의 개수 : %d \t시간 : %dms", N, N, testcase, end-start);
//		System.out.printf("순열 %dP%d의 개수 : %d", N, N, testcase);
		
	}
	
	/**
	 * 순열을 만들 함수
	 * cnt : 배열의 index
	 */
	private static void permutation(int cnt) {
		
		if(cnt == N) { 
			testcase++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<N+1; i++) {
			if(!selected[i]) { 		// 숫자 i가 사용되지 않은 경우
				numbers[cnt] = i; 	// 중복되지 않는 경우 cnt번째에 i 데이터를 넣는다.
				selected[i] = true; // i 숫자를 사용했다고 표시
				permutation(cnt+1);	//
				// #############중요해요##############
				selected[i] = false; // 다른 순열로 생성을 위해 미사용으로 표시
			}
		}
	}

}
