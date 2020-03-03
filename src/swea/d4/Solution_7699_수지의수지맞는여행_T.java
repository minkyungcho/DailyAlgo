package swea.d4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_7699_수지의수지맞는여행_T {
	
	static int result;
	static int R, C; // 행, 렬 
	static int[][] map;
//	static char[][] map;
//	static int[][] visit; // 0,1,2,3
	static int[] visit; // 방문 안함 0, 방문 1 
	static int[] dx = {0,0,-1,1}; // 상 하 좌 우  
	static int[] dy= {-1,1,0,0};
	static Set<Character> set = new HashSet<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t < TC+1; t++) {
			result = 0; // 최대값, 최소값
//			set.clear();
			// 입력 
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R][C];
//			map = new char[R][C];
//			visit = new int[R][C]; // 0 초기화 : 방문안함,  1  : 방문
			visit = new int[26+1]; // 0 초기화 : 방문안함,  1  : 방문
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j) - 'A';
//					map[i][j] = s.charAt(j);
				}
			}
			// 처리 
			dfs(1-1,1-1, 1);
			// 출력 
			System.out.println("#"+t+" "+result);
		}
		
		
	}

	private static void dfs(int x, int y, int cnt) {
		// 종료  
		result = Math.max(result, cnt);
		if(cnt==26) {
			return;
		}
		// 실행 && 재귀호출 
//		visit[y][x] = 1;
		visit[map[y][x]] = 1;
//		set.add(map[y][x]);
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 범위채크 
			if(nx<0 || nx>=C || ny<0 || ny>=R) {
				continue;
			}
			// 방문체크
			if(visit[map[ny][nx]]==1) {
				continue;
			}
//			if(visit[ny][nx]==1) {
//				continue;
//			}
			// 알파벳 중복 체크 
			if(set.contains(map[ny][nx])) {
				continue;
			}
			// 재귀호출 
			dfs(nx, ny, cnt+1);
//			visit[ny][nx] = 0; // 방문해제
			visit[map[ny][nx]] = 0; // 방문해제
//			set.remove(map[ny][nx]);
		}
		
	}

}
