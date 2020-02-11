package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPn3_bit {
	
	static int N; 			// 원소 수
	static int[] numbers; 	// 순열을 담을 배열
	static int testcase; 	// 순열의 수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long start = System.currentTimeMillis();
		numbers = new int[N]; 
		permutation(0, 0); // 
		long end = System.currentTimeMillis();
		System.out.printf("순열 %dP%d의 개수 : %d \t시간 : %dms", N, N, testcase, end-start);
//		System.out.printf("순열 %dP%d의 개수 : %d", N, N, testcase);
		
	}
	
	/**
	 * 순열을 만들 함수
	 * cnt : 배열의 index
	 * flag : 데이터의 중복 여부를 검사할 bit mask
	 */
	private static void permutation(int cnt, int flag) {
		
		if(cnt == N) { 
			testcase++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		top:
		for(int i=1; i<N+1; i++) {
			// 중복검사 : 0번째 원소부터 현재 원소 전까지 i값이 출현했는지 검사
			if((flag & 1<<i) == 0) { // 0 이면 사용하지 않은 것, 0이 아니면 사용한 것
				// 중복되지 않은 경우 cnt 번째에 i 데이터를 넣는다.
				numbers[cnt] = i;
				permutation(cnt+1, flag | 1<<i); // flag에 i 사용했다고 표시한다.
			}
		}
	}

}
