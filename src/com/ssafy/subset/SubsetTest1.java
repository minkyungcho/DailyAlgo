package com.ssafy.subset;

import java.util.Arrays;

public class SubsetTest1 {
	
	static String[] datas = {"a", "b", "c", "d"};
	
	public static void main(String[] args) {
		
		 int[] subset = new int[datas.length];
		 for(int i=0; i<2; i++) {
			 subset[0] = i;
			 for(int j=0; j<2; j++) {
				 subset[1] = j;
				 for(int k=0; k<2; k++) {
					 subset[2] = k;
					 for(int l=0; l<2; l++) {
						 subset[3] = l;
						 print(subset);
//						 System.out.println(Arrays.toString(subset));
					 }
				 }
			 }
		 }
	}

	private static void print(int[] subset) {
		
		int k=0;
		System.out.print("[");
		for(int s : subset) {
			if(s != 0) {
				System.out.print(datas[k]+" ");
			}
			k++;
		}
		System.out.println("]");
	}
}
