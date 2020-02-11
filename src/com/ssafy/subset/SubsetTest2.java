package com.ssafy.subset;

public class SubsetTest2 {
	
	public static void main(String[] args) {

		int[] arr = {3,6,7,1,5};
		int n = arr.length;
		
		/**
		 * subset의 개수는 2^n 개 이므로 
		 * size : 1<<n (2^n=2^4=16)
		 * 0 : 원소 선택 안함 	1 : 원소를 선택함 
		 * 
		 * 	0	0000	: 원소 하나도 선택안한 서브셋
		 * 	1	0001	: 맨 끝의 원소 하나를 선택한 서브셋
		 * 	2	0010	: 맨끝에서 두번째 원소 하나를 선택한 서브셋
		 * 	3	0011	: 맨 끝의 두개의 원소를 선택한 서브셋
		 * 	...
		 * size-1 	1111	: 모든 원소 선택한 서브셋
		 * 
		 * O(1<<n) : n이 20개까지는 1초 안에 subset들을 구할 수 있다.
		 * O(1<<n *n) 
		 */
		for(int i=0, size=1<<n; i<size; i++) { // i : 0 ~ 15
			for(int j=0; j<n; j++) {
				if((i & 1<<j) != 0) {
					// 0이 아니면 선택된 것. 0이면 선택안한것이기 때문에 출력할 필요 없음
					// System.out.print(j+" ");
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
