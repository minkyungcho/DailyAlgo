package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님_T2 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int T;
	static int R;
	static int C;
	static char map[][];
	static String result;
	static Queue<Point> points;

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
			
			result = null;
			
			points = new LinkedList<>();
			
			Point player = null;
			
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {
						points.offer(new Point(r, c, 0, true));
					} else if (map[r][c] == 'S') {
						player = new Point(r, c, 0, false);
					}
				}
			}
			
			points.offer(player); // ****S : 악마들 queue에 넣고 난 후에 수연이가 마지막으로 들어감.
			
			// 이제 탐험 시작
			// 끝나는 시점 : 모든 수연이 소멸할때까지 or 수연이가 여신에게 도달할때까지.
			outer : while (!points.isEmpty()) {
				Point front = points.poll();
				
				// 사방 탐색 
				for (int d = 0; d < 4; d++) {
					int nr = front.row + dir[d][0];
					int nc = front.col + dir[d][1];

					if (isIn(nr, nc)) { // 범위 내에 있다면 수연이는 . 으로 이동, D를 만나면 땡 
						if(front.isDevil) { // 악마처럼 움직이기. 
							if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
								// 지도의 상태를 변경한 것 자체가 방문처리.
								map[nr][nc] = '*';
								// 큐에 새로 들어가긴 하지만 빠지지는 않는다.
								points.offer(new Point(nr, nc, front.depth + 1, true));
							}
						}else { // 수연이처럼 움직이기. 
							if (map[nr][nc] == 'D') {
								result = (front.depth+1)+"";
								break outer;
							}else if(map[nr][nc]=='.') {
								map[nr][nc] = 'S';
								points.offer(new Point(nr, nc, front.depth+1, false));
							}
						}
					}
				}
				
			}
			
			if(result==null) {
				result = "GAME OVER";
			}
			
			System.out.println("#" + tc + " " + result);
		}

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < R && c < C;
	}

	static class Point {
		int row;
		int col;
		int depth;
		boolean isDevil; // 악마인가 아닌가. 

		public Point(int row, int col, int depth, boolean isDevil) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isDevil = isDevil;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}

	}

}
