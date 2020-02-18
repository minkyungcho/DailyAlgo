package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visit;
	static int cnt = 0;

	// rightup right rightdown
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/boj/3109_빵집.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int r = 0; r < R; r++) {
			dfs(r, 0);
		}

//		print();
		System.out.println(cnt);

	}

	private static boolean dfs(int r, int c) {
		if(c==C-1) {
			cnt++;
			return true;
		}
		int nr, nc;
		for (int d = 0; d < 3; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc]=='.' && !visit[nr][nc]) {
				visit[nr][nc] = true;
				if(dfs(nr, nc)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
