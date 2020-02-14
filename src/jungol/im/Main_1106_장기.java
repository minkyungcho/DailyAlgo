package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1106_장기 {

	static int[][] dir = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };

	static int rowN;
	static int colN;
	static int srow;
	static int scol;
	static int erow;
	static int ecol;
	static int[][] map;
	static int[][] visit;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/im/1106_장기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];

		st = new StringTokenizer(br.readLine());
		srow = Integer.parseInt(st.nextToken()) - 1;
		scol = Integer.parseInt(st.nextToken()) - 1;
		erow = Integer.parseInt(st.nextToken()) - 1;
		ecol = Integer.parseInt(st.nextToken()) - 1;

		bfs(srow, scol);
		System.out.println(map[erow][ecol] - 1);
	}

	private static void bfs(int r, int c) {

		if (r == erow && c == ecol) {
			return;
		}
		LinkedList<int[]> q = new LinkedList<int[]>();
		map[r][c] = 1;
		q.offer(new int[] { r, c });

		int[] cur;
		int nr, nc;
		int t;
		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			t = map[r][c];
//			System.out.println(r+" "+c+" "+t);
			for (int d = 0; d < 8; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if (nr > -1 && nr < rowN && nc > -1 && nc < colN && map[nr][nc] == 0) {
					map[nr][nc] = t + 1;
//					System.out.println(nr+" "+nc);
//					print();
//					System.out.println("-----------------");
					q.offer(new int[]{ nr, nc });
				}
			}
		}

	}

	private static void print() {

		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
