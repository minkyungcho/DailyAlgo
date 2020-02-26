package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	
	static int T;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int result;
	
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/2178_미로탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			String str;
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			bfs();
			
//			print();
			
			System.out.println(result);
		}
	}
	
	private static void bfs() {
		
		LinkedList<int[]> q = new LinkedList<>();
		map[0][0] = 2;
		q.offer(new int[] {0,0});
		
		int[] cur;
		int nr, nc, r, c, t;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			t = map[r][c];
			
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc]==1) {
					map[nr][nc] = t+1;
					if(nr==N-1 && nc==M-1) {
						result = t;
						return;
					}else {
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
