package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int[][] map;
	static boolean[][] visit;
	static boolean[][] outside; // 치즈 밖 영역 
	static int R, C;
	static int time;
	static int cheeseCnt;
	static int lastCheeseCnt;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		outside = new boolean[R][C];
		cheeseCnt = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {
					cheeseCnt++;
				}
			}
		}
		
//		for(int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		Queue<int[]> q = new LinkedList<>();
		time = 0;
		while(cheeseCnt != 0) {
			lastCheeseCnt = cheeseCnt;
			
			// 치즈 밖 영역 지정하기. 치즈 내에 있는 구멍은 치즈가 녹는거랑 상관없음.
			bfs(0,0);
			
			// 모든 치즈 주변 확인 
			visit = new boolean[R][C]; // 바깥치즈 visit 에 저장 
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]==1) {
						if(isEdge(r, c)) {
							visit[r][c] = true;
						}
					}
				}
			}
			
			// 남은 치즈 개수 세기 
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(visit[r][c]) {
						if(map[r][c]==1) {
							cheeseCnt--;
						}
						map[r][c] = 0;
						outside[r][c] = true;
					}
				}
			}
			time++;
			//print();
		}
		
		System.out.println(time);
		System.out.println(lastCheeseCnt);
	}

	static void bfs(int row, int col) {
		visit = new boolean[R][C];
		Queue<int[]> q1 = new LinkedList<>();
		outside[row][col] = true;
		q1.add(new int[] {row,col});
		while(!q1.isEmpty()) {
			int[] front = q1.poll();
			for (int d = 0; d < 4; d++) {
				int nr = front[0] + dirs[d][0];
				int nc = front[1] + dirs[d][1];
				if(isIn(nr, nc) && map[nr][nc]==0 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					outside[nr][nc] = true;
					q1.add(new int[] {nr, nc});
				}
			}
		}
		
	}

	static boolean isIn(int r, int c) {
		return 0<=r&&r<R && 0<=c&&c<C;
	}

	static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

	static boolean isEdge(int row, int col) {
		//System.out.println(row+" "+col);
		for (int d = 0; d < 4; d++) {
			int nr = row + dirs[d][0];
			int nc = col + dirs[d][1];
			if(outside[nr][nc]) { // 상하좌우 바깥 공기인지? 
				return true;
			}
		}
		return false;  
	}

}
