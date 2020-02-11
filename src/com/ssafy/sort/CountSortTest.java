package com.ssafy.sort;

import java.util.Arrays;

public class CountSortTest {

	public static void main(String[] args) {
		
		int[] data = {0,4,1,3,1,2,4,1};
		int n = data.length;
		int[] temp = new int[n];
		
		// step1. max값 찾고 카운트 배열 선언
		int max = Integer.MIN_VALUE;
		for(int d : data) {
			max = Math.max(max, d);
		}
		int[] count = new int[max+1];
		
		// step2. 데이터 카운팅 (데이터의 출현 빈도수)
		for(int d : data) {
			count[d]++;
		}
		
		// step3. 카운팅 배열에 빈도수를 누적하기
		for(int i=1; i<max+1; i++) {
			count[i] += count[i-1];
		}
//		System.out.println(Arrays.toString(count));
		
		// step4. 데이터 배열과 카운트 배열 값을 참조해서 temp 배열에 정렬하기
		int idx = -1; // temp 배열에 저장할 index
		int d = -1;
		for(int i=n-1; i>-1; i--) {
			d = data[i]; 			// 데이터 == count 배열의 index
			idx = --count[d];	// temp 배열의 index
			temp[idx] = d;
		}
		System.out.println(Arrays.toString(temp));
		
	}

}
