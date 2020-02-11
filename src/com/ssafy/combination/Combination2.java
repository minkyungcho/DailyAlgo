package com.ssafy.combination;

import java.util.Scanner;

public class Combination2 {
	
//	static int[] arr = {3,6,7,1,5};
	static int[] arr = {1,2,3,4,5};
	static int r;
	static int[] combi;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		int n = arr.length;
		combi = new int[n]; // subset을 만들기 때문에
		
		int k; // 배열의 index => 조합의 수 
		
		for(int i=0, size=1<<n; i<size; i++) { // i : 0 ~ 15
			k = 0;
			for(int j=0; j<n; j++) {
				if((i & 1<<j) != 0) {
					combi[k++] = j;
				}
			}
			if(k==r) {
				print();
			}
		
		}
	}
	private static void print() {
		
		for(int i=0; i<r; i++) {
			System.out.print(arr[combi[i]]+" ");
		}
		System.out.println();
		
	}
}
