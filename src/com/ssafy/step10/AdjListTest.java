package com.ssafy.step10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
	
	static class Node{
		int to;
		Node link;
		
		public Node(int to, Node link) {
			super();
			this.to = to;
			this.link = link;
		}
		
		public Node(int to) {
			super();
			this.to = to;
		}
	}
	
	private static Node[] adjList; // 인접리스트 
	private static int N; // 총 정점 수 
	private static boolean[] visit; // 방문표시 배열 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수 
		int M = sc.nextInt(); // 간선 수
		adjList = new Node[N+1]; // 정점 노드 1부터 시작
		visit = new boolean[N+1]; // index 1부터 시작 
		/*
		 * 7 8
		 * 1 2
		 * 1 3
		 * 무향그래프 
		 */
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]); // 1이랑 2랑 서로 연결 
			adjList[to] = new Node(from, adjList[to]);
		}
		
		//dfs(1);
		bfs(1);
		
	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit[cur] = true;
		queue.offer(cur);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char)(current+64)+" ");
			
			for(Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visit[temp.to]) {
					visit[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}
		System.out.println();
	}
	/**
	 * 
	 * @param cur : 현재 정점 
	 */
	private static void dfs(int cur) {
		
		visit[cur] = true; // 자기자신이 방문관리 
		System.out.println((char)(cur+64));
		
		for(Node temp=adjList[cur]; temp != null; temp = temp.link) {
			// 현재 정점 시작노드부터 출발, 노드가 null이 아닐때까지, 다음 노드로 연결 
			
			if(!visit[temp.to]) {
				dfs(temp.to);
			}
		}
		
	}

}
