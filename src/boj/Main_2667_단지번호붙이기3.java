package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기3 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	
	static int aptNum;
	
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		aptNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
					aptNum++;
				}
			}
		}
		
//		print();
		
		int[] aptArr = new int[aptNum];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0) {
					aptArr[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(aptArr);
		
		System.out.println(aptNum-1);
		for (int i = 1; i < aptArr.length; i++) {
			System.out.println(aptArr[i]);
		}
		
	}

	private static void bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		map[i][j] = aptNum;
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] first = q.poll();
			int r = first[0];
			int c = first[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dirs[d][0];
				int nc = c + dirs[d][1];
				
				if(IsIn(nr, nc) && map[nr][nc] == 1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = aptNum;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
	}

	private static boolean IsIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

	private static void print() {
		
		for(int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		
	}

}
