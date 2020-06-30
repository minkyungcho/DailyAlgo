package boj;

import java.util.Scanner;

public class Main_2579_계단오르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] memo = new int[N+1];
		for (int i = 1; i <= N ; i++) {
			arr[i] = sc.nextInt();
		}
		if(N>3) {
			memo[1] = arr[1];
			memo[2] = Math.max(arr[1]+arr[2], arr[2]);
			memo[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		}else {
			if(N==1) {
				System.out.println(arr[1]);
				return;
			}else if(N==2) {
				System.out.println(arr[2]+arr[1]);
				return;
			}else {
				System.out.println(Math.max(arr[1]+arr[3], arr[2]+arr[3]));
				return;
			}
		}
		for (int i = 4; i <= N; i++) {
			memo[i] = Math.max(memo[i-2]+arr[i], memo[i-3]+arr[i]+arr[i-1]);
		}
		System.out.println(memo[N]);
	}

}
