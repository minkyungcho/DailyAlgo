package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전거스름돈 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 8;
		int[] c = new int[n+1];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = i; // 1원짜리 필요한 개수 
		}
		System.out.println(Arrays.toString(c));

		for (int i = 4; i < c.length; i++) {
			// c[i] : 1원짜리 동전만 고려한 최소개수 
			// c[i-4]+1 : 1원, 4원 짜리 동전 고려한 최소개수 
			if(c[i] > c[i-4]+1) {
				c[i] = c[i-4]+1;
			}
		}
		System.out.println(Arrays.toString(c));

		for (int i = 6; i < c.length; i++) {
			// c[i] : 1원짜리 동전만 고려한 최소개수 
			// c[i-6]+1 : 1원, 4원, 6원 짜리 동전 고려한 최소개수 
			if(c[i] > c[i-6]+1) {
				c[i] = c[i-6]+1;
			}
		}
		System.out.println(Arrays.toString(c));
		
		
		System.out.println(c[n]);
	}

}
