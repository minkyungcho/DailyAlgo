package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2806_NQueen {

	static int T;
	static int N;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d3/2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase < T + 1; testcase++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];

			Queen(0);

			System.out.println("#" + testcase + " " + result);
		}

	}

	private static void Queen(int cnt) {
		if (cnt == N) {
			result++;
			return;
		}
		for (int n = 0; n < N; n++) {
			arr[cnt] = n;
			if (isP(cnt)) {
				Queen(cnt + 1);
			}
		}
	}

	private static boolean isP(int cnt) {
		// cnt행까지 확인
		for (int i = 0; i < cnt; i++) {
			// 같은열에 있는지 확인
			if (arr[cnt] == arr[i])
				return false;
			// 대각선에 있는지 확인
			// 대각선 확인 행크기 차이와 열 값의 차이가 같으면 대각선에 위치한다!
			int row = Math.abs(cnt - i);
			int col = Math.abs(arr[cnt] - arr[i]);
			if (row == col)
				return false;
		}
		return true;
	}

}
