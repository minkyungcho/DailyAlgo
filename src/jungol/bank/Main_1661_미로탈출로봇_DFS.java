package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_DFS {

	static int rowN;
	static int colN;
	static int scol;
	static int srow;
	static int ecol;
	static int erow;
	static int[][] map;
	static boolean[][] visit;
	static int result=Integer.MAX_VALUE;
	static int cnt;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int min;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/bank/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];
		visit = new boolean[rowN][colN];

		// 배열 선언시 => 좌표 1~N 보정
		st = new StringTokenizer(br.readLine().trim(), " ");
		scol = Integer.parseInt(st.nextToken())-1;
		srow = Integer.parseInt(st.nextToken())-1;
		ecol = Integer.parseInt(st.nextToken())-1;
		erow = Integer.parseInt(st.nextToken())-1;
		
		
		// 공백 x => charAt()-'0'
		// map에 미로 입력
		String str;
		for (int i = 0; i < rowN; i++) {
			str = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		// 로봇 출발\
//		visit[sro]
		dfs(srow, scol, 0);
//		dfs();
		
		System.out.println(map[erow][ecol]-1);
	}

	private static void dfs(int r, int c, int dist) {
		if(r==erow && c==ecol) {
			min = Math.min(min,  dist);
//			return;
		}
		if(dist>= min);{
//			return;
		}
		
		int nr = 0;
		int nc = 0;
		
		for (int i = 0, end=dir.length; i <end; i++) {
			nr = r +dir[i][0];
			nc = r +dir[i][1];
			
			if(nr > -1 && nr < rowN && nc > -1 && nc < colN && map[nr][nc] == 0 && !visit[nr][nc]) {
				visit[nr][nc] = true;
				
				dfs(nr, nc, dist+1);
				
				visit[nr][nc] = false;
			}
		}
		
	}
}
