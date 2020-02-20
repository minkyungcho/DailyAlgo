package com.ssafy.sort;

import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = data.length;
		//sorted = new int[size];
		quickSort(data, 0, size - 1);
		System.out.println(Arrays.toString(data));
	}

	private static void quickSort(int[] data, int begin, int end) {
		
		if(begin<end) {
			int p = begin, left = begin+1, right = end, temp;
			
			// 피봇을 중심으로 피봇의 왼쪽에는 피복보다 작은 값은, 오른쪽에는 피봇 보다 큰값을 위치
			do {
				// 피봇보다 큰 값을 찾기
				while(left<end && data[left]<data[p]) left++;
				
				// 피봇보다 작은 값을 찾기
				while(right>p && data[right]>=data[p]) right--;
				
				if(left<right) {
					temp = data[left];
					data[left] = data[right];
					data[right] = temp;
				}
				
			}while(left<right);
			
			// 피봇을 이동 시킨다.
			temp = data[p];
			data[p] = data[right];
			data[right] = temp;
			
			// 왼쪽 정렬
			quickSort(data, begin, right-1);
			// 오른쪽 정렬
			quickSort(data, right+1, end);

		}
		
	}

}
