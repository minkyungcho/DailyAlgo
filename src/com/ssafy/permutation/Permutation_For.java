package com.ssafy.permutation;

public class Permutation_For {

	public static void main(String[] args) {
		
		System.out.println("========중복순열========");
		int n = 3; // 3^3 = 27
		int cnt = 0;
		// for문의 개수는 r과 같다
		for(int i=1; i<n+1; i++) { 			// 첫번째 원소 뽑기
			for(int j=1; j<n+1; j++) { 		// 두번째 원소 뽑기
				for(int k=1; k<n+1; k++) { 	// 세번째 원소 뽑기
					cnt++;
					System.out.printf("%d %d %d\n", i, j, k);
				}
			}
		}
		System.out.printf("%dㅠ%d의 개수 : %d\n", n, n, cnt);

		System.out.println("========순열========");
//		int n = 3; // 3^3 = 27
		cnt = 0;
		// for문의 개수는 r과 같다
		for(int i=1; i<n+1; i++) { 			// 첫번째 원소 뽑기
			for(int j=1; j<n+1; j++) { 		// 두번째 원소 뽑기
				if(i != j) {				// 중복 검사
					for(int k=1; k<n+1; k++) { 	// 세번째 원소 뽑기
						if(k != i && k != j) {
							cnt++;
							System.out.printf("%d %d %d\n", i, j, k);
						}
					}
				}
			}
		}
		System.out.printf("%dP%d의 개수 : %d\n", n, n, cnt);
	}

}
