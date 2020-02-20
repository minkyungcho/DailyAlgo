package com.ssafy.sort;

import java.util.Arrays;

public class MergeSortTest {

	// 두 그룹을 정렬할 때 임시로 사용할 배열, 정렬할 데이터 크기만큼 설정한다.
	static int[] sorted;

	public static void main(String[] args) {

		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = data.length;
		sorted = new int[size];
		mergeSort(data, 0, size - 1);

	}

	private static void mergeSort(int[] data, int start, int end) {
//		if (start == end) {
//			return;
//		}
		if (start < end) {
			int mid = (start + end)>>1;
			mergeSort(data, start, mid);
			mergeSort(data, mid+1, end);
			merge(data, start, mid, end);
		}
	}

	private static void merge(int[] data, int s, int mid, int n) {
		
		// 병합시 필요한 변수, s,n 값은 변경되면 안되므로 따로 변수로 선언한다.
		int start = s, end = n, next = mid+1, k = s;
		
		while(start<=mid && next<=end) {
			// 두그룹의 데이터를 비교 후 두 그룹 중 작은 데이터 순으로 sorted 배열에 임시로 정렬한다.
			if(data[start]<=data[next]) {
				sorted[k] = data[start++];
			}else {
				sorted[k] = data[next++];
			}
			k++;
		}
	
		// 임시로 정렬된 sorted 배열의 data 배열에 있는 남은 데이터를 옮겨 높는다.
		if(start>mid) {
			for (int i = next; i<=n; i++, k++) {
				sorted[k] = data[i];
			}
		}else {
			for (int i = start; i<=mid; i++, k++) {
				sorted[k] = data[i];
			}
		}
 		
		// sorted 배열의 데이터를 data 배열로 옮기기
		for (int i = s; i <= n; i++) {
			data[i] = sorted[i];
		}
		System.out.print("병합정렬 >> ");
		System.out.println(Arrays.toString(data));
	}

}
