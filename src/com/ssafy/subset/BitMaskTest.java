package com.ssafy.subset;

public class BitMaskTest {

	public static void main(String[] args) {
		/**
		 * i의 j번째 bit가 1인지 아닌지 검사 : i & 1<<j
		 */
		for(int i=0; i<5; i++) {
			printBit(i);
		}
		
	}

	private static void printBit(int i) {
		for(int j=7; j>=0; j--) {
			System.out.printf("%d", (i & 1<<j) == 0 ? 0 : 1);
		}
		System.out.println();
		
	}

}
