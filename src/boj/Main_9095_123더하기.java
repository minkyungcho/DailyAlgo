package boj;

import java.util.Scanner;

public class Main_9095_123더하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] memo = new int[12];
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			memo[1] = 1;
			memo[2] = 2;
			memo[3] = 4;
			for (int j = 4; j <=N ; j++) {
				memo[j] = memo[j-1] + memo[j-2] + memo[j-3];
			}
			
			System.out.println(memo[N]);
			
		}
		
	}

}
