package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1209_Sum {
	
	static int T = 10;
	static int N;
	static int maxSum;
	static int sum;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/1209_Sum.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testcase = 1; testcase < T + 1; testcase++) {
			map = new int[100][100];
			N = Integer.parseInt(br.readLine());
			maxSum = 0;
			StringTokenizer st;
			int n;
			for (int i = 0; i < 100; i++) {
				sum = 0;
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					sum+=n;
				}
				if(sum>maxSum) {
					maxSum = sum;
				}
			}
//			System.out.println("행 max: "+maxSum);
			
			for (int i = 0; i < 100; i++) {
				sum=0;
				for (int j = 0; j < 100; j++) {
					sum+=map[j][i];
				}
				if(sum>maxSum) {
					maxSum = sum;
				}
			}
//			System.out.println("열 max: "+maxSum);
			
			for (int i = 0; i < 100; i++) {
				sum=0;
				for (int j = 0; j < 100; j++) {
					if(i==j) {
						sum+=map[j][i];
					}
				}
				if(sum>maxSum) {
					maxSum = sum;
				}
			}
//			System.out.println("대각선 max: "+maxSum);
			
			
			System.out.println("#"+testcase+" "+maxSum);
		}
	}
}
