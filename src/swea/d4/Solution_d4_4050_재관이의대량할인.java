package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_d4_4050_재관이의대량할인 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/4050_재관이의대량할인.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			Integer[] prices = new Integer[N];
			int total = 0;
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
				total += prices[i];
			}
			Arrays.sort(prices, Collections.reverseOrder());
//			System.out.println(Arrays.toString(prices));
			int sale = 0;
			for (int i = 2; i < N; i+=3) {
				sale += prices[i];
			}
			System.out.println("#"+tc+" "+(total-sale));
		
		}
		
	}

}
