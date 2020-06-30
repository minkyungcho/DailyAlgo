package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기_T {

	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int N;
	static int[][] map;
	static int islandIdx;
	static int MinDist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 섬 구별해주기 
		islandIdx = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==1) {
					bfs(r, c);
					islandIdx++;
				}
			}
		}
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		// 2. 각 섬에서 다른 섬까지의 최단 거리 찾아보기.
		MinDist = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]>1) {
					getShortBridgeLength(r, c);
				}
			}
		}
		System.out.println(MinDist);
		
	}

	static void getShortBridgeLength(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, map[row][col], 0));
		boolean[][] visit = new boolean[N][N];
		visit[row][col] = true;
		while(!q.isEmpty()) {
			Point front = q.poll();
			if(front.d >= MinDist) {
				break;
			}
			for (int d = 0; d < dir.length; d++) {
				int nr = front.r + dir[d][0];
				int nc = front.c + dir[d][1];
				if(isIn(nr,nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					
					if(map[nr][nc]==front.idx) { // 이 섬의 내륙지방 
						continue;
					} else if(map[nr][nc]==0) { // 바다 --> 다리연결 
						q.offer(new Point(nr, nc, front.idx, front.d+1));
					} else if(map[nr][nc] != front.idx) { // 다른 섬 
						MinDist = Math.min(MinDist, front.d);
						return;
					}
				}
			}
		}
	}

	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, islandIdx));
		// 방문 처리 
		map[row][col] = islandIdx;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int nr = p.r + dir[d][0];
				int nc = p.c + dir[d][1];
				if(isIn(nr,nc) && map[nr][nc]==1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc, islandIdx));
				}
			}
		}
		
	}
	
	static boolean isIn(int row, int col) {
		return 0<=row&&row<N && 0<=col&&col<N;
	}
	
	static class Point{
		int r, c, idx;
		int d; // bfs의 depth

		public Point(int r, int c, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.idx = idx;
		}

		public Point(int r, int c, int idx, int d) {
			this(r, c, idx);
			this.d = d;
		}
		
	}
	
}
