package com.ssafy.subset;

import java.util.Arrays;

public class SubsetTest3 {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		int[] arr = {3,6,7,1,5};
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		// 20개까지는 0.368초 라서 여유있음
		// 21개는 1.178초 라서 위험하다
		
		
		int n = arr.length;
		int size = 1<<n;
		int[] select = new int[n];
		int[][] subset = new int[size][n];
		
		for(int i=0; i<size; i++) { // i : 0 ~ 15
			for(int j=0; j<n; j++) {
				if((i & 1<<j) != 0) {
					select[j] = 1; // j번째 원소가 선택된 경우 이므로 1을 설정
				}
			}
			subset[i] = Arrays.copyOf(select, n);
			Arrays.fill(select, 0);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
}
