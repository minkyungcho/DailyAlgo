package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {

	static int T;
	static int N;
	static int M;
	static char map[][];
	static boolean visit[][];
	static String result;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int rDevilStart;
	static int cDevilStart;
	static int rSStart;
	static int cSStart;
	static int rD;
	static int cD;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d5/7793_오나의여신님.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			result = "GAME OVER";
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new boolean[N][M];
			
			String str;
			char c;
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < M; j++) {
					c = str.charAt(j);
					map[i][j] = c;
					if(c=='*') {
						rDevilStart = i;
						cDevilStart = j;
					}else if(c=='S') {
						rSStart = i;
						cSStart = j;
					}else if(c=='D') {
						rD = i;
						cD = j;
					}
				}
			}
			
			bfs(rDevilStart, cDevilStart);
			
			
			
			System.out.println("#"+tc+" "+result);
		}
		
	}


	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		
		
	}

}
