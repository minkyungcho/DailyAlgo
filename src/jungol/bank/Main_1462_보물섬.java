package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬 {

	static int rowN;
	static int colN;
	static int[][] time;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int max = 0;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/jungol/bank/1462_보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
		map = new char[rowN][colN];
		time = new int[rowN][colN];
		visit = new boolean[rowN][colN];
		
		String str;
		for (int i = 0; i < rowN; i++) {
			str = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = str.charAt(j);
			}
			
		}

		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if(map[i][j]=='L') {
					time[i][j]=1;
					bfs(i, j);
					time = new int[rowN][colN];
					visit = new boolean[rowN][colN];
				}
			}
			
		}
//		print();
		
		System.out.println(max-1);
		
	}


	private static void bfs(int r, int c) {
		
		LinkedList<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		int[] cur;
		int nr, nc, t;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			t = time[r][c];
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				
				if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc]=='L' && !visit[nr][nc]) {
					time[nr][nc] = t+1;
					if(time[nr][nc]>max) {
						max = time[nr][nc];
					}
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
	}


	private static void print() {
		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				System.out.print(time[i][j] + " ");
			}
			System.out.println();
		}
	}

}
