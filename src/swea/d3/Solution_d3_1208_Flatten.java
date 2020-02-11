package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_1208_Flatten {

	static int T = 10;
	static int N;
	static int[] boxes;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("res/1208_Flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result;
		for (int testcase = 1; testcase < T + 1; testcase++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			boxes = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			int min = Integer.MAX_VALUE;
			int maxidx = 0;
			int minidx = N;
			while (N > 0) {
				max = 0;
				min = Integer.MAX_VALUE;
				maxidx = 0;
				minidx = N;
				for (int i = 0; i < 100; i++) {
					if (max < boxes[i]) {
						max = boxes[i];
						maxidx = i;
					}
					if (min > boxes[i]) {
						min = boxes[i];
						minidx = i;
					}
				}
				boxes[maxidx]--;
				boxes[minidx]++;
				N--;
			}
			max = 0;
			min = Integer.MAX_VALUE;
			maxidx = 0;
			minidx = 100;
			for (int i = 0; i < 100; i++) {
				if (max < boxes[i]) {
					max = boxes[i];
					maxidx = i;
				}
				if (min > boxes[i]) {
					min = boxes[i];
					minidx = i;
				}
			}
			result = max - min;

			System.out.println("#" + testcase + " " + result);
		}
	}

}