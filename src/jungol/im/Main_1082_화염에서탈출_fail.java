package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출_fail {
	
	static int T;
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visit;
	static boolean[][] fvisit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int rD;
	static int cD;
	static int srS;
	static int scS;
	static int min;
	static int t;
	static String result;
	static LinkedList<int[]> fireQ = new LinkedList<>();
	static LinkedList<int[]> sQ = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/jungol/im/1082_화염에서탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			fvisit = new boolean[R][C];
			t = 0;
			result = "impossible";
//			min = 
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='S'){
						srS = i;
						scS = j;
						sQ.offer(new int[] {srS, scS, t});
					}else if(map[i][j]=='D') {
						rD = i;
						cD = j;
					}else if(map[i][j]=='*') {
						fvisit[i][j] = true;
						fireQ.offer(new int[] {i,j});
					}
				}
			}
			
			
			
//			fire();
//			move(srS, scS);
			
			bfs();
			
			print();
			
			System.out.println("#"+testcase+" "+result);
		}
		
		
	}
	
	
	private static void bfs() {
		
		visit[srS][scS] = true;
		
		int[] cur;
		int[] fcur;
		int nr, nc, r, c;
		int fnr, fnc, fr, fc;
		while(!fireQ.isEmpty() || !sQ.isEmpty()) {
			
			// fire
			System.out.println("fire move");
			int qsize = fireQ.size();
			for (int n = 0; n < qsize; n++) {
				fcur = fireQ.poll();
				fr = fcur[0];
				fc = fcur[1];
				
				for (int d = 0; d < 4; d++) {
					fnr = fr + dir[d][0];
					fnc = fc + dir[d][1];
					
//					char tmp = map[fnr][fnc];
					if(fnr>-1 && fnr<R && fnc>-1 && fnc<C ) {
						if(map[fnr][fnc]=='.') {
							map[fnr][fnc] = '*';
							fvisit[fnr][fnc] = true;
							fireQ.offer(new int[] {fnr, fnc});
						} 
//						else if()
					}
				}
			}
			print();
			// S move
			System.out.println("S move");
			cur = sQ.poll();
//			System.out.println(cur[0]);
			r = cur[0];
			c = cur[1];
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
//				char tmp = map[nr][nc];
				if(nr>-1 && nr<R && nc>-1 && nc<C && (map[nr][nc]=='.'||map[nr][nc]=='D')) {
					if(map[nr][nc]=='.') {
//						map[r][c] = '.';
//						map[nr][nc] = 'S';
						visit[nr][nc] = true;
						sQ.offer(new int[] {nr,nc,t+1});
					}else if(map[nr][nc]=='D') {
						result = (t+1)+"";
						return;
					}
				}
			}
			print();
//			return;
		}
		
	}


	private static boolean move(int r, int c) {
		
		
		visit[r][c] = true;
//		fireQ.offer(new int[]{r, c});
//		sQ.offer(new int[]{r, c, t});
		int[] cur;
		int nr, nc;
		while(!fireQ.isEmpty() || !sQ.isEmpty()) {
			cur = sQ.poll();
			r = cur[0];
			c = cur[1];
//			t = cur[2];
			
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				char tmp = map[nr][nc];
				if(nr>-1 && nr<R && nc>-1 && nc<C && (tmp=='.'||tmp=='D')) {
					if(tmp=='.') {
						visit[nr][nc] = true;
//						q.offer(new int[] {nr,nc,t+1});
					}else if(tmp=='D') {
						
						return true;
					}
				}
			}
			
		}
		return false;
		
	}


	private static void fire() {
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='*') {
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc]=='.') {
							 map[nr][nc] = '*';
						}
					}
				}
			}
		}
		
	}


	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
