package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님_T {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int T;
	static int R;
	static int C;
	static char map[][];
	static boolean visit[][];
	static String result;
	static Queue<Point> devil, player;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d5/7793_오나의여신님.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];

			devil = new LinkedList<>();
			player = new LinkedList<>();

			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {
						devil.offer(new Point(r, c, 0));
					} else if (map[r][c] == 'S') {
						player.offer(new Point(r, c, 0));
					}
				}
			}

			// 이제 탐험 시작
			// 끝나는 시점 : 모든 수연이 소멸할때까지 or 수연이가 여신에게 도달할때까지.
			while (true) {
				// 1. 만약 player가 없다면 --> game over
				if (player.size() == 0) {
					break;
				}
				// 2. devil 이 1초 동작 --> ., S 를 만나면 오염시킨다.
				bfsDevil();
				// 3. player가 동작 --> .으로 아동, D 를 만나면 종료.
				result = bfsPlayer();
				if(result == null) {
					result = "GAME OVER";
				}
			}

			System.out.println("#" + tc + " " + result);
		}

	}

	private static String bfsPlayer() {

		int size = player.size();

		while (size-- > 0) {
			Point front = player.poll();

			// 자식 탐색 - 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = front.row + dir[d][0];
				int nc = front.col + dir[d][1];

				if (isIn(nr, nc)) { // 범위 내에 있다면 수연이는 . 으로 이동, D를 만나면 땡 
					if (map[nr][nc] == 'D') {
						return (front.depth+1)+"";
					}else if(map[nr][nc]=='.') {
						map[nr][nc] = 'S';
						player.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}

		return null;
	}

	// 현재 queue에 있는 놈까지만 돈다.!! 새로운 녀석은 그냥 담아둘뿐..
	// size()
	private static void bfsDevil() {

		int size = devil.size();

		while (size-- > 0) {
			Point front = devil.poll();

			// 자식 탐색 - 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = front.row + dir[d][0];
				int nc = front.col + dir[d][1];

				if (isIn(nr, nc)) { // 범위 내에 있다면 악마는 ., S를 대상으로 이동
					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
						// 지도의 상태를 변경한 것 자체가 방문처리.
						map[nr][nc] = '*';
						// 큐에 새로 들어가긴 하지만 빠지지는 않는다.
						devil.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < R && c < C;
	}

	static class Point {
		int row;
		int col;
		int depth;

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}

	}

}
