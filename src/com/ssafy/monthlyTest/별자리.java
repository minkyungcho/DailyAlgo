package com.ssafy.monthlyTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 별자리 {

	static int T;

	static int[][] map;
	static boolean[][] visit;
	static int result;
    static int[][] dir = { {-1,-1}, {-1,0},{-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1} };
    
	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/별자리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc < T + 1; tc++) {
			map = new int[10][10];
			visit = new boolean[10][10];
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//print();
			int num = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j, ++num);
					}
				}
			}

			//print();

			System.out.println("#" + tc + " " + num);

		}

	}

	private static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int r, int c, int num) {
		LinkedList<int[]> q = new LinkedList<>();
		int[] cur;
		int nr, nc, rr, cc;
		visit[r][c] = true;
		map[r][c] = num;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			cur = q.poll();
			rr = cur[0];
			cc = cur[1];
			for (int d = 0; d < 8; d++) {
				nr = rr + dir[d][0];
				nc = cc + dir[d][1];
				if (nr > -1 && nc > -1 && nr < 10 && nc < 10 && map[nr][nc]==1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = num;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}

}
