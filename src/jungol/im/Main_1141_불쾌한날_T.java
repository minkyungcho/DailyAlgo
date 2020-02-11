package jungol.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1141_불쾌한날_T {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/im/1141_불쾌한날.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cows = new int[n];
		long cnt = 0;
		for(int i=0; i<n; i++) {
			cows[i] = sc.nextInt();
		}
		
		int curCow;
		for(int i=0; i<n; i++) {
			curCow = cows[i];
			for(int j=i+1; j<n; j++) {
				if(curCow > cows[j]) {
					cnt++;
				}else {
					break;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
