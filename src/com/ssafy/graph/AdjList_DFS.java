package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class AdjList_DFS {

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
//			for (int i = 0; i < N; i++) {
//				System.out.printf("%d:%s\n", i, glist[i]);
//			}
			dfs(0);
			System.out.println();
		}
		
	}


	private static void dfs(int cur) {
		Stack<Integer> s = new Stack<>();
		s.push(cur);
		GraphNode temp = null;
		while(!s.isEmpty()) {
			cur = s.pop();
			if(!visit[cur]) {
				System.out.printf("%c->", cur+65);
				visit[cur] = true;
				temp = glist[cur];
				while(temp!=null) {
					s.push(temp.vertex);
					temp = temp.link;
				}
				
			}
			
		}
	}

}
