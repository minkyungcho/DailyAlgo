package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9659_다항식계산 {

	static int T, N, M;
	static int[] arrT, arrA, arrB, arrM;
	static long[] memo;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/9659_다항식계산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			arrT = new int[N+2];
			arrA = new int[N+2];
			arrB = new int[N+2];
			memo = new long[N+2];
			
			for (int i = 2; i < N+1; i++) {
				st = new StringTokenizer(br.readLine()," ");
				arrT[i] = Integer.parseInt(st.nextToken());
				arrA[i] = Integer.parseInt(st.nextToken());
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			arrM = new int[M];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.print("#"+t);
			for (int i = 0; i < M; i++) {
				memo[0] = 1;
				memo[1] = arrM[i];
				for (int j = 2; j < N+1; j++) {
					switch (arrT[j]) {
					case 1:
						memo[j] = (memo[arrA[j]] + memo[arrB[j]]) % 998244353;
						break;
					case 2:
						memo[j] = (arrA[j] * memo[arrB[j]]) % 998244353;
						break;
					case 3:
						memo[j] = (memo[arrA[j]] * memo[arrB[j]]) % 998244353;
						break;
					}
				}
				System.out.print(" "+memo[N]);
			}
			System.out.println();
		}
	}	

}
