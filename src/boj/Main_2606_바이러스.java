package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	static boolean[][] map;
	static boolean[] visit;
	static int N;
	static int M;
	static int cnt;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		visit = new boolean[N];
		StringTokenizer st;
		cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = true;
			map[b][a] = true;
		}
		
		//print();
		
		bfs(0);
		System.out.println(cnt);
	}

	private static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);
		visit[r] = true;
		while(!q.isEmpty()){
			int front = q.poll();
			for (int i = 0; i < N; i++) {
				if(map[front][i] && !visit[i]) {
					visit[i] = true;
					
					q.add(i);
					cnt++;
					//System.out.println(front+" "+i);
				}
			}
		}
		
	}

	private static void print() {
		for(boolean[] a : map) {
			System.out.println(Arrays.toString(a));
		}
	}

}
