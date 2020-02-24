package com.ssafy.greedy;

import java.util.Scanner;

public class GreedyEx1 {
	
	static int[] coin = {500,400,100,50,10};
//	static int[] coin = {500,100,50,10};
	static int[] result = new int[coin.length];

	static void coinChagnge(int money) {
		for (int i = 0, size=coin.length; i < size; i++) {
			result[i] = money/coin[i];
			money %= coin[i];
		}
	}
	
	static void print() {
		System.out.println("동전교한결과");
		for (int i = 0, size=coin.length; i < size; i++) {
			if(result[i]==0) continue;
			System.out.printf("%d원 : %d개\n", coin[i], result[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("거스름돈을 입력하세요 : ");
		int money = sc.nextInt();
		coinChagnge(money);
		print();
		
	}

}
