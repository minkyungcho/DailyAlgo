package swea.모의SW역테;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사_T {
	
	static int N, min;
	static int[][] S;
	static boolean[] visit;
	
	static int[] number;

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("res/swea/모의sw역테/4012_요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+tc+" "+min);
		}
	
	}
	
	static void comb(int cnt, int cur) {
		/* ############################### */
		if(cur>=N) return; // 가지치기를 통해 반으로 줄이기!!!
		/* ############################### */
		if(cnt==N/2) { // N개 중에서 R개 뽑기. --> N개 중에서 반만 뽑는다! N/2 
			// 시너지의 최소값 구하기 
			int sum1 = 0; // 
			int sum0 = 0; // 홀수 일때 계산 
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(visit[i] != visit[j]) continue;
					if(visit[i]) { // true 일 때 
						sum1 += S[i][j] + S[j][i];
					}else {
						sum0 += S[i][j] + S[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(sum1-sum0));
			return;
		}
		for (int i = cur; i < N; i++) {
			visit[i] = true;
			comb(cnt+1, i+1);
			visit[i] = false;
		}
	}
	
}
