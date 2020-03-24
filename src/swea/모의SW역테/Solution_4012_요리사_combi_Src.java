package swea.모의SW역테;

import java.util.Arrays;

public class Solution_4012_요리사_combi_Src {
	
	static int N, R, totalCnt;
	static int[] number;
	static boolean[] visit;
	
	public static void main(String[] args) {
		N = 4;
		R = 2;
		totalCnt = 0;
		number = new int[R];
		visit = new boolean[N];
		comb(0,0);
		System.out.println(totalCnt);
	}
	
	static void comb(int cnt, int cur) {
		/* ############################### */
		if(cur>=N) return; // 반으로 줄이기!!!
		/* ############################### */
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(number)+" "+Arrays.toString(visit));
			return;
		}
		for (int i = cur; i < N; i++) {
			visit[i] = true;
			number[cnt] = i;
			comb(cnt+1, i+1);
			visit[i] = false;
		}
	}
	
}
