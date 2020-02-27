package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {

	static int T = 10;
	static int t;
	static int endR;
	static int endC;
	static int result;
	static int[][] map;
	static boolean[][] visit;

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d4/1210_Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testcase = 1; testcase < T + 1; testcase++) {
			map = new int[100][100];
			visit = new boolean[100][100];
			result = 0;
			t = Integer.parseInt(br.readLine());
			int n;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					n = Integer.parseInt(st.nextToken());
					if (n == 2) {
						endR = i;
						endC = j;
					}
					map[i][j] = n;
				}
			}

			dfs(endR, endC);
//			print();
			System.out.println("#" + t + " " + result);
		}
	}

	private static void dfs(int r, int c) {

		for (int d = 0; d < 3; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if (nr > -1 && nc > -1 && nr < 100 && nc < 100 && map[nr][nc] == 1 && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc);
				break;
			} 

		}
		if(r==0) {
			result = c;
		}

	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
