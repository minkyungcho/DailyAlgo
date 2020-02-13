package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇 {

	static int X;
	static int Y;
	static int x1;
	static int x2;
	static int y1;
	static int y2;
	static int[][] map;
	static int[][] visit;
	static int result=0;
	static int cnt;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/bank/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		visit = new int[X][Y];

		st = new StringTokenizer(br.readLine());

		y1 = Integer.parseInt(st.nextToken())-1;
		y2 = Integer.parseInt(st.nextToken())-1;
		x1 = Integer.parseInt(st.nextToken())-1;
		x2 = Integer.parseInt(st.nextToken())-1;
		
		// map에 미로 입력
		String str;
		for (int i = 0; i < X; i++) {
			str = br.readLine();
			for (int j = 0; j < Y; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// map[i][j]가 0일때 사방탐색
		cnt=0;
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if(map[i][j]==0 && visit[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		
		print();
		System.out.println(result);
//		System.out.println(Y + X + x1 + x2 + y1 + y2);
	}

	private static void bfs(int r, int c) {
		
		if(r==y2 && c==x2) {
			if(result < cnt-1) {
				result = cnt-1;
			}
			cnt=0;
		}
		
		LinkedList<int[]> q = new LinkedList<>();
		visit[r][c] = ++cnt;
		q.offer(new int[] {r,c});
		int[] cur;
		int nr, nc;
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr>-1 && nr<Y && nc>-1 && nc<X && map[nr][nc]==0 && visit[nr][nc]==0) {
					visit[nr][nc] = cnt+1;
					q.offer(new int[] {nr,nc});
				}
			}
			
		}
		
		
	}

	private static void print() {

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}
}
