package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

	// 1 : 상하좌우	2 : 상하		3 : 좌우		4 : 상우 		
	// 5 : 하우		6 : 하좌 		7 : 상좌
	static boolean[][][] map;
	static boolean[][] visit;
	static int R, C;
	static int sR, sC;
	static int L;
	static int count;
	//					   상		 좌		하		우 
	static int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d9/1953_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			sR = Integer.parseInt(st.nextToken());
			sC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new boolean[R][C][4];
			visit = new boolean[R][C]; 
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					int temp = Integer.parseInt(st.nextToken());
					switch(temp) {
					case 1:
						map[i][j][0] = true;
						map[i][j][1] = true;
						map[i][j][2] = true;
						map[i][j][3] = true;
						break;
					case 2:
						map[i][j][0] = true;
						map[i][j][2] = true;
						break;
					case 3:
						map[i][j][1] = true;
						map[i][j][3] = true;
						break;
					case 4:
						map[i][j][0] = true;
						map[i][j][3] = true;
						break;
					case 5:
						map[i][j][2] = true;
						map[i][j][3] = true;
						break;
					case 6:
						map[i][j][1] = true;
						map[i][j][2] = true;
						break;
					case 7:
						map[i][j][0] = true;
						map[i][j][1] = true;
						break;
						
					}
				}
			}
//			for(int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
			count = 1;
			bfs(sR, sC, 1);
			
			System.out.println("#"+tc+" "+count);
//			if(tc==3) break;
		
		}
		
	}

	private static void bfs(int row, int col, int time) {
		visit[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col, time});
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int r = front[0];
			int c = front[1];
			int t = front[2];
			if(t >= L) return;
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if(isIn(nr,nc) && !visit[nr][nc] && map[r][c][d] && map[nr][nc][(d+2)%4]) {
					count++;
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc, t+1});
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return 0<=r&&r<R && 0<=c&&c<C;
	}

}
