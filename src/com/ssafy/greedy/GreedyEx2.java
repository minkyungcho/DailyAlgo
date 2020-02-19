package com.ssafy.greedy;

import java.util.Scanner;

public class GreedyEx2 {

	public static void main(String[] args) {
		
		int[] gap = {0, 20, 25, 35, 17, 24, 20, 32, 13};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("연료를 가득 채우면 몇 마일까지 달릴 수 있는가? 마일을 입력하세요 : ");
		
		int mile = sc.nextInt();
		int totalMile = 0;
		for (int i = 0, size = gap.length; i < size; i++) {
			totalMile += gap[i];
			if( (totalMile+gap[i+1]) > mile ) {
				System.out.println("주유중~"+i);
				totalMile = 0;
			}
		}
		
		
		
		
	}

}
