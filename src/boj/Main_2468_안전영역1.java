package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역1 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] rain;
	static int maxHeight;
	static int maxRegion;
	static int regionNum;
	
	static int[][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		maxHeight = 0;
		maxRegion = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				maxHeight = Math.max(maxHeight, a);
			}
		}
		rain = new int[maxHeight+1];
		
		for (int i = 1; i < maxHeight+1; i++) {
			visit = new boolean[N][N];
			checkRainHeight(i);
			regionNum = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!visit[r][c]) {
						bfs(r, c);
						regionNum++;
					}
				}
			}
//			System.out.println("RESULT : "+maxRegion+" "+regionNum);
			maxRegion = Math.max(maxRegion, regionNum);
		}
		
//		System.out.println(maxHeight);
		System.out.println(maxRegion==0?1:maxRegion);
	}

	private static void bfs(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		visit[r][c] = true;
		while(!q.isEmpty()) {
			int[] front = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = front[0] + dir[d][0];
				int nc = front[1] + dir[d][1];
				if(IsIn(nr, nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
	}

	private static boolean IsIn(int r, int c) {
		return 0<=r&&r<N && 0<=c&&c<N;
	}

	private static void checkRainHeight(int h) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]<=h) {
					visit[i][j] = true;
				}
			}
		}
	}

}

/*

5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1 

5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */ 
