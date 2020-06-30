package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static ArrayList<CCTV> list;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(1<=map[r][c] && map[r][c]<=5) {
					list.add(new CCTV(c, r, map[r][c]));
				}
			}
		}
		dfs(0, map);
		
		System.out.println(result);
	}
	
	static void dfs(int idx, int[][] nMap) {
		// 기저조건 
		if(idx == list.size()) {
			int cnt = 0;
			// 사각지대 개수 세기 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(nMap[i][j]==0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		// 재귀호출 
		// 리스트에서 CCTV 뽑아서 감시 솔루션 
		CCTV cctv = list.get(idx); // 현재 위치 CCTV 뽑기.
		int x = cctv.x;
		int y = cctv.y;
		int[][] vMap = new int[N][M];
		switch(cctv.type) {
		case 1 : // 1번 감시 카메라 
			for (int d = 0; d < 4; d++) {
				// 걈시 
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				// 다음 CCTV 호출
				dfs(idx+1, vMap);
				// 백트래킹 X
			}
			break;
		case 2 : // 2번 감시 카메라 
			for (int d = 0; d < 2; d++) {
				// 걈시 
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, d+2);
				// 다음 CCTV 호출
				dfs(idx+1, vMap);
				// 백트래킹 X
			}
			break;
		case 3 : // 3번 감시 카메라 
			for (int d = 0; d < 4; d++) {
				// 걈시 
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, (d+1)%4); // d=4 -> d=0 
				// 다음 CCTV 호출
				dfs(idx+1, vMap);
				// 백트래킹 X
			}
			break;
		case 4 : // 4번 감시 카메라 
			for (int d = 0; d < 4; d++) {
				// 걈시 
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, (d+1)%4); // d=4 -> d=0 
				detect(x, y, vMap, (d+2)%4); // d=4 -> d=0 
				// 다음 CCTV 호출
				dfs(idx+1, vMap);
				// 백트래킹 X
			}
			break;
		case 5 : // 5번 감시 카메라 
			// 걈시 
			for (int i = 0; i < N; i++) {
				vMap[i] = Arrays.copyOf(nMap[i], M);
			}
			detect(x, y, vMap, 0);
			detect(x, y, vMap, 1);
			detect(x, y, vMap, 2);
			detect(x, y, vMap, 3);
			// 다음 CCTV 호출
			dfs(idx+1, vMap);
			// 백트래킹 X
			break;
		}
	}

	static void detect(int r, int c, int[][] cMap, int dir) {
		// 상하좌우 감시 
		// 0: 왼쪽, 1: 상, 2:오른쪽, 3:아래 
		switch(dir) {
		case 0 : // 왼쪽 
			for (int i = r; i >= 0; i--) {
				if(cMap[c][i] == 6) {
					break;
				}
				cMap[c][i] = 9;
			}
			break;
		case 2 : // 오른쪽 
			for (int i = r; i < M; i++) {
				if(cMap[c][i] == 6) {
					break;
				}
				cMap[c][i] = 9;
			}
			break;
		case 1 : // 위쪽 
			for (int i = c; i >= 0; i--) {
				if(cMap[i][r] == 6) {
					break;
				}
				cMap[i][r] = 9;
			}
			break;
		case 3 : // 위쪽 
			for (int i = c; i < N; i++) {
				if(cMap[i][r] == 6) {
					break;
				}
				cMap[i][r] = 9;
			}
			break;
		}
	}

	static class CCTV{
		int x, y;
		int type;
		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
		@Override
		public String toString() {
			return "CCTV [x=" + x + ", y=" + y + ", type=" + type + "]";
		}
		
	}
}
