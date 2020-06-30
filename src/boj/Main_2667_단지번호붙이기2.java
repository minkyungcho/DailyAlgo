package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기2 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int aptNum;
	
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		//print();
		aptNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					bfs(i,j); // 
					aptNum++;
				}
			}
		}
//		System.out.println("----------------");
//		print();
		System.out.println(aptNum-1);
		
		int[] aptCnt = new int[aptNum];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0) {
					aptCnt[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(aptCnt);
		
		for (int i = 1; i < aptNum; i++) {
			System.out.println(aptCnt[i]);
		}
		
	}


	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visit[i][j] = true;
		map[i][j] = aptNum;
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int r = front[0];
			int c = front[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if( IsIn(nr, nc) && map[nr][nc]==1 && !visit[nr][nc]) {
					q.add(new int[] {nr, nc});
					visit[nr][nc] = true;
					map[nr][nc] = aptNum;
				}
			}
			
		}
		
	}


	private static boolean IsIn(int r, int c) {
		return 0<=r&&r<N && 0<=c&&c<N;
	}


	private static void print() {
		
		for(int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		
	}

}
