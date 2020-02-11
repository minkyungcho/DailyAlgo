package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17471_게리맨더링 {
	
	static int N;
	static int[] p;
	static int[][] tree;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/17471_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		tree = new int[N+1][N+1];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N+1; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int start=1; start<N+1; start++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int end = Integer.parseInt(st.nextToken());
				tree[start][end]=1;
			}
		}
		
		printT();
	}

	private static void printT() {
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(tree[i][j] + " ");
			}
			System.out.println();
		}
	}

}
