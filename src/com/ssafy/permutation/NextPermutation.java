package com.ssafy.permutation;

import java.util.Arrays;

public class NextPermutation {

//	static int[] p = {1, 2, 3}; // 순열로 만들고 싶은 숫자를 배열에 넣는다.
	static int[] p = { 1, 2, 3, 0, 0, 0}; // 조합, 0 이면 선택한.

	public static void main(String[] args) {

		int size = p.length - 1;
		do {
			System.out.println(Arrays.toString(p));
		} while (np(size)); // np가 없을때까지 계속 permutation을 만들겠다.
	}

	/**
	 * 순열이나 조합을 만들때 배열의 처음부터 데이터를 만들지 않고 중복 check도 하지 않고 재귀로 처리하지 않기 때문에 빠르게 순열이나
	 * 조합을 구할 수 있다.
	 * 
	 * @param size 배열의 마지막 접근 범위
	 * @return 다음 순열이나 조합을 만들수 있는지 여부
	 */
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
