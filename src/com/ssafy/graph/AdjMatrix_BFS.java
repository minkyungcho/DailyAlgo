package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AdjMatrix_BFS {

	static int[][] map;
	static boolean[] visit;
	static int N;
	
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/lecture/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(0); // 0번 행부터 탐색 
			System.out.println();
		}
		
	}


	/**
	 * 그래프를 너비우선탐색하는 기능
	 * @param cur	탐색할 첫 노드(node, vertex)
	 */
	private static void bfs(int cur) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		visit[cur] = true;	// bfs는 queue에 넣을 때 방문 표시한다.  
		queue.offer(cur);	// 탐색할 첫 노드를 큐에 넣는다
		while(!queue.isEmpty()) {
			cur = queue.poll();	// 탐색할 노트
			System.out.printf("%c->", cur+65);
			for (int ad = 0; ad < N; ad++) {		// 탐색할 노드의 인접된 노드가 있는지 검사
				if(map[cur][ad]>0 && !visit[ad]) {	// ad는 cur에 인접된 경우 : 0보다 크고 방문하지 않은경우
					visit[ad] = true;				// 방문처리 
					queue.offer(ad);				// 큐에 담아서 다음 번에 탐색 
				}
			}
		}
		
	}

}
