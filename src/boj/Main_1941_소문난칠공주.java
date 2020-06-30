package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난칠공주 {
	
	static char[][] map;
	static boolean[] visit = new boolean[25];
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int result = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		for(char[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		for (int i = 0; i < 25; i++) {
			dfs(i, 1, 0);
		}
		
		
		System.out.println(result);
	}

	static void dfs(int idx, int cnt, int sCnt) {
		if(map[idx/5][idx%5] == 'S') {
			sCnt++;
		}
		
		// 기저조건 
		if(cnt==7) {
			if(sCnt >= 4) { // 4명 이상이냐 
				if(bfs(idx/5, idx%5)) { // 연결되어 있느냐 
					result++;
				}
			}
			visit[idx] = false;
			return;
		}
		visit[idx] = true;
		for (int i = idx+1; i < 25; i++) {
			if(visit[i]) { // 선택 
				continue;
			}
			dfs(i, cnt+1, sCnt);
		}
		// 백트래킹 
		visit[idx] = false;
	}

	static boolean bfs(int y, int x) {
		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(x, y));
		boolean[][] v1 = new boolean[5][5];
		v1[y][x] = true;
		Data d1 = null;
		int vCnt = 1;
		while(!q.isEmpty()) {
			d1 = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = d1.x + dirs[d][0];
				int ny = d1.y + dirs[d][1];
				if(isIn(nx, ny) && !v1[ny][nx] && !visit[ny*5 + nx]) {
					v1[ny][nx] = true;
					q.offer(new Data(nx, ny));
					vCnt++;
				}
			}
		}
		return vCnt == 7 ? true : false;
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x&&x<5 && 0<=y&&y<5;
	}

	static class Data{
		int x, y;

		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
