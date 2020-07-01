package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {

	static int N;
	static int M;
	static boolean[][] map;
	static boolean[] visit;
	static int start;
	static int end;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(a == b) {
				System.out.println(cnt);
			}else {
				map[a][b] = true;
				map[b][a] = true;
			}
		}
		bfs(start-1, 0);
		if(cnt!=0) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
	}

	private static void bfs(int now, int depth) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {now, depth});
		visit[now] = true;
		while(!q.isEmpty()) {
			int[] front = q.poll();
			for (int i = 0; i < N; i++) {
				if(map[front[0]][i] && !visit[i]) {
//					System.out.println(front[0]+" "+i+"     "+front[1]);
					visit[i] = true;
					q.add(new int[] {i, front[1]+1});
					if(i==end-1) {
						cnt = front[1]+1;
						return;
					}
				}
			}
			
		}
		
		
	}

}
/*
9
5 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6

9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
*/
