package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러 {

	static int T;
	static int N;
	static int[][] worm;
	static boolean[] numbers;
	static long min;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d4/1494_사랑의카운슬러.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T + 1; testcase++) {
			N = Integer.parseInt(br.readLine());
			worm = new int[N][2];
			numbers = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				worm[i][0] = Integer.parseInt(st.nextToken());
				worm[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Long.MAX_VALUE;
			combination(0, 0);
			System.out.println("#" + testcase + " "+min);
		}

	}

	private static void combination(int cnt, int start) {
		
		long X = 0;
		long Y = 0;
		
		if (cnt == N/2) {
			
			for (int i = 0; i < N; i++) {
				
				if(!numbers[i]) {
					X -= worm[i][0];
					Y -= worm[i][1];
				}else {
					X += worm[i][0];
					Y += worm[i][1];
				}

			}
			
			min = Math.min(min, X*X+Y*Y);
			
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[i] = true;
			combination(cnt + 1, i + 1);
			numbers[i] = false;
			
		}

	}
}
