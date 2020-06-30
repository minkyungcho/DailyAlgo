package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	
	static int N;
	static int[][] map;
	static boolean[] height;
	static boolean[][] visit;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우 
	static int safeIslandNum;
	static int maxSafeIslandNum;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		height = new boolean[101]; // 높이는 1 ~ 100 
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				height[map[r][c]] = true;
			}
		}
		
//		for(int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		
//		maxSafeIslandNum = Integer.MIN_VALUE;
		maxSafeIslandNum = 1; // 아무지역도 물에 안잠기는 경우가 있다. 이런경우 최대 안전영역의 개수는 1이다.
		for (int i = 1; i <= 100; i++) {
			if(height[i]) {
				safeIslandNum = 0;
				sink(i);
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!visit[r][c]) {
							safeIslandNum++;
							bfs(r, c);
						}
					}
				}
				maxSafeIslandNum = Math.max(maxSafeIslandNum, safeIslandNum);
			}
		}
		
		System.out.println(maxSafeIslandNum);
		
	}

	static void bfs(int row, int col) {
		visit[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		while(!q.isEmpty()) {
			int[] front = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = front[0] + dirs[d][0];
				int nc = front[1] + dirs[d][1];
				if(isIn(nr, nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

	static boolean isIn(int row, int col) {
		return 0<=row&&row<N && 0<=col&&col<N;
	}

	static void sink(int h) {
		visit = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] <= h) { // 높이가 h보다 작거나 같으면 물에 잠긴다. 
					visit[r][c] = true;
				}
			}
		}
	}

}
