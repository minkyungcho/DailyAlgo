package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList_BFS {

	static int N;
	static GraphNode[] glist;
	static boolean[] visit;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/lecture/AdjList.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T+1; tc++) {
			N = sc.nextInt();
			glist = new GraphNode[N];
			visit = new boolean[N];
			int link = sc.nextInt();
			int node, ad;
			
			for (int i = 0; i < link; i++) {
				node = sc.nextInt();
				ad = sc.nextInt();
				glist[node] = new GraphNode(ad, glist[node]);
			}
			for (int i = 0; i < N; i++) {
				System.out.printf("%d:%s\n", i, glist[i]);
			}
			bfs(0);
		}
		
	}


	private static void bfs(int cur) {
		
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(cur);
		visit[cur] = true;
		GraphNode temp = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			System.out.printf("%c->", cur+65);
			temp = glist[cur];
			while(temp!=null) {
				if(!visit[temp.vertex]) {
					visit[temp.vertex] = true;
					q.offer(temp.vertex);
				}
				temp = temp.link;
			}
			
		}
				
		
	}

}
