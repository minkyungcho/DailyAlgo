package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_d3_1215_회문1 {

	static int T = 10;
	static int N;
	static String[][] map = new String[8][8];

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("res/1215_회문1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result;
		for (int testcase = 1; testcase < T + 1; testcase++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j) + "";
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					StringBuffer sb = new StringBuffer();
					String str = "";
					for (int k = 0; k < N; k++) {
						str += map[i][j + k];
					}
					String str2 = str.substring(0, N / 2);
					String str3;
					if (N % 2 == 0) {
						str3 = str.substring(N / 2);
					} else {
						str3 = str.substring(N / 2 + 1);
					}
					sb.append(str2);
					String strRv = sb.reverse().toString();
					if (str3.equals(strRv)) {
						result++;
					}
				}
			}
			for (int i = 0; i < 8 - N + 1; i++) {
				for (int j = 0; j < 8; j++) {
					StringBuffer sb = new StringBuffer();
					String str = "";
					for (int k = 0; k < N; k++) {
						str += map[i + k][j];
					}
					String str2 = str.substring(0, N / 2);
					String str3;
					if (N % 2 == 0) {
						str3 = str.substring(N / 2);
					} else {
						str3 = str.substring(N / 2 + 1);
					}
					sb.append(str2);
					String strRv = sb.reverse().toString();
					if (str3.equals(strRv)) {
						result++;
					}
				}
			}

			System.out.println("#" + testcase + " " + result);
		}
	}
}