package com.ssafy.permutation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BabyJinTest {

	static int[] p;
	static int T;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/lecture/babygin.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		go:
		for (int testcase = 1; testcase < T + 1; testcase++) {

			String str = br.readLine();
			int len = str.length();
			p = new int[len];
			for (int i = 0; i < len; i++) {
				p[i] = str.charAt(i) - 48;
			}

			int runF;
			int triF;
			int size = p.length - 1;
			Arrays.sort(p);
			do {
				runF = 0;
				triF = 0;

				int p1 = p[0];
				int p2 = p[1];
				int p3 = p[2];
				int p4 = p[3];
				int p5 = p[4];
				int p6 = p[5];
				if (p1 + 1 == p2 && p1 + 2 == p3) {
					runF++;
				} else if (p1 == p2 && p1 == p3) {
					triF++;
				}

				if (p4 + 1 == p5 && p4 + 2 == p6) {
					runF++;
				} else if (p4 == p5 && p4 == p6) {
					triF++;
				}
				if (runF + triF == 2) {
					System.out.print("#" + testcase + " ");
					System.out.println("BABYGIN");
					continue go;
				}

			} while (np(size));
			System.out.println("#" + testcase + " XXX");
		}
	}

	private static boolean np(int size) {
		int i = size;

		// 교차점 찾기 : 작은 데이터를 만날때까지
		while (i > 0 && p[i - 1] >= p[i])
			i--;

		// 교차점 데이터를 찾지 못한 경우 => 데이터가 오름차순으로 시작했는데 모든 데이터를 다 교차해서 내림차순이 된 경우
		if (i == 0)
			return false;

		// 교차할 데이터 찾기
		int j = size;
		while (p[i - 1] >= p[j])
			j--;

		// 작은 데이터를 찾은 경우 i-1데이터와 j번째 데이터를 swap
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;

		j = size;
		while (i < j) {
			temp = p[i];
			p[i] = p[j];
			p[j] = temp;
			i++;
			j--;
		}
		return true;
	}
}
