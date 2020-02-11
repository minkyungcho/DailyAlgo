package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPn {
	
	static int N; 			// 원소 수
	static int[] numbers; 	// 순열을 담을 배열
	static int testcase; 	// 순열의 수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long start = System.currentTimeMillis();
		numbers = new int[N]; 
		permutation(0); // 
		long end = System.currentTimeMillis();
		System.out.printf("순열 %dP%d의 개수 : %d \t시간 : %dms", N, N, testcase, end-start);
		
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
		top:
		for(int i=1; i<N+1; i++) {
			// 중복검사 : 0번째 원소부터 현재 원소 전까지 i값이 출현했는지 검사
			for(int j=0; j<cnt; j++) {
				if(numbers[j]==i) { // 중복된 경우
					continue top;
				}
			}
			// 중복 검사해서 중복안되게 만들면 순열!!
			// 중복되지 않는 경우 cnt번째에 i 데이터를 넣는다.
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

}
