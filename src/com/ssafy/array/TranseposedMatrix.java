package com.ssafy.array;

public class TranseposedMatrix {

	public static void main(String[] args) {

		int[][] datas = { { 1, 2, 3 }
						, { 4, 5, 6 }
						, { 7, 8, 9 } };
		int n = datas.length;
		
		int temp = 0;
		
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				if(i<j) {
					temp = datas[i][j];
					datas[i][j] = datas[j][i];
					datas[j][i] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				System.out.print(datas[i][j] + " ");
			}
			System.out.println();
		}

	}

}
