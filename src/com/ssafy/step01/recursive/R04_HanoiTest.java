package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R04_HanoiTest {
	
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 2, 3);
		System.out.println(result.toString());
		
		
	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {
		
		if(cnt==0) return;
		
		// 시작기둥의 cnt-1 덩어리 원판을 임시기둥으로 옮김.
		hanoi(cnt-1, from, to, temp);
		
		// 시작기둥의 cnt원한 목적기둥으로 옮김.
		result.append(cnt+" : "+from+"->"+to+"\n");
		
		// 
		hanoi(cnt-1, temp, from, to);
	}
	
}
