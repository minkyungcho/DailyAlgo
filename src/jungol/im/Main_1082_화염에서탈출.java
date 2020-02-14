package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출 {
	
	static int T;
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int rD;
	static int cD;
	static int srS;
	static int scS;
	static int min;
	
	
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
			
			String result="impossible";
//			min = 
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='S'){
						srS = i;
						scS = j;
					}else if(map[i][j]=='D') {
						rD = i;
						cD = j;
					}
				}
			}
			
			fire();
			move(srS, scS);

			print();
			
			System.out.println("#"+testcase+" "+result);
		}
		
		
	}
	
	
	private static boolean move(int r, int c) {
		int t=0;
		LinkedList<int[]> q= new LinkedList<>();
		visit[r][c] = true;
		q.offer(new int[]{r, c, t});
		int[] cur;
		int nr, nc;
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			t = cur[2];
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				char tmp = map[nr][nc];
				if(nr>-1 && nr<R && nc>-1 && nc<C && (tmp=='.'||tmp=='D')) {
					if(tmp=='.') {
						visit[nr][nc] = true;
						q.offer(new int[] {nr,nc,t+1});
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
