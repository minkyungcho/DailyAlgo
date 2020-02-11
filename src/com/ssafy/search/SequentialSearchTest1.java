package com.ssafy.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SequentialSearchTest1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/lecture/search.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(sequential(numbers, 11));
	}
	
	/**
	 * 정렬이 안되어 있는 배열에서 원하는 데이터의 위치를 찾는 기능
	 * @param numbers 	배열
	 * @param keys		찾을 데이터
	 * @return			찾은 데이터의 index를 리턴, 못 찾은 경우 -1을 리턴한다.
	 */
	private static int sequential(int[] numbers, int key) {
		
		for(int j=0, size=numbers.length; j<size; j++) {
			if(numbers[j] == key) {
				return j;
			}
		}
		return -1;
	}

}
