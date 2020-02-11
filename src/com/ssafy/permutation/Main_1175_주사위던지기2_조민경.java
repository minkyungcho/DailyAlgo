package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1175_주사위던지기2_조민경 {
	
	static int N; 			// 주사위 개수
	static int S; 			// 주사위 눈의 합
	static int[] numbers; 	// 순열을 담을 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		numbers = new int[N]; // N개 배열
		permutation(0); // 
		
	}
	
	/**
	 * 순열을 만들 함수
	 * cnt : 배열의 index
	 */
	private static void permutation(int cnt) {
		
		// R 만큼만 뽑으면 된다!
		if(cnt == N) { // 원소를  N개 만큼만 추출
			if(checkSum()) {
				for(int n : numbers) {
					System.out.print(n+" ");
				}
				System.out.println();
				return;
				
			}
			return;
		}
		for(int i=1; i<7; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

	public static boolean checkSum() {
		int sum = 0;
		for(int n : numbers) {
			sum += n;
		}
		if(sum == S) {
			return true;
		}else {
			return false;			
		}
	}

}
