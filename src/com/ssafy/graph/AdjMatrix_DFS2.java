package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class AdjMatrix_DFS2 {

	static int[][] map;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/lecture/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0); // 0번 행부터 탐색
			System.out.println();
		}

	}

	/**
	 * 그래프를 높이 우선탐색하는 기능
	 * 
	 * @param cur 탐색할 첫 노드(node, vertex)
	 */
	private static void dfs(int cur) {

		visit[cur] = true; // 방문했다고 표시
		System.out.printf("%c->", cur + 65);
		for (int ad = 0; ad < N; ad++) {
			if (map[cur][ad] == 1 && !visit[ad]) {
				dfs(ad);
			}
		}

	}

}
