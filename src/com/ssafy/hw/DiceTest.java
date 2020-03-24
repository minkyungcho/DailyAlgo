package com.ssafy.hw;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, M, number[], totalCnt;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		number = new int[N];
		isSelected = new boolean[7]; // 1,2,3,4,5,6

		switch (M) {
		case 1: // 주사위 던지기 1 : 중복순열
			dice1(0);
			break;
		case 2: // 주사위 던지기 2 : 순열
			dice2(0);
			break;
		case 3: // 주사위 던지기 3 : 중복조합
			dice3(0, 1);
			break;
		case 4: // 주사위 던지기 4 : 조합
			dice4(0, 1);
			break;
		}
		System.out.println("총 경우의 수 : " + totalCnt);

	}

	// 주사위던지기 1 : 중복순열
	private static void dice1(int cnt) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			number[cnt] = i;
			dice1(cnt + 1);
		}
	}

	// 주사위던지기 2 : 순열
	private static void dice2(int cnt) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			number[cnt] = i;
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// 주사위던지기 3 : 중복조합
	private static void dice3(int cnt, int cur) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		for (int i = cur; i <= 6; i++) { // cur ~ 6
			number[cnt] = i;
			dice3(cnt + 1, i);
		}
	}

	// 주사위던지기 4 : 조합
	private static void dice4(int cnt, int cur) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		for (int i = cur; i <= 6; i++) { // cur ~ 6
			number[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}
}
