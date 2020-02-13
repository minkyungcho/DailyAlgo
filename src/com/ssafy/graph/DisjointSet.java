package com.ssafy.graph;

import java.util.Arrays;

/**
 * 	DisjointSet => 두 노드가 같은 그래프에 속해있는지 판별
 *	index	: 노드 번호
 *	값		: root, 부모 노드의 index를 표현 
 *
 */
public class DisjointSet {
	
	static int[] parent;
	
	/**
	 * DisjointSet을 위한 배열을 초기화
	 * - 모든 노드가 root로 초기화
	 */
	public static void makeSet(int v) {
		parent[v] = v;
	}
	
	/**
	 * 특정 노드의 root를 찾아 반환하는 기능
	 */
	public static int findSet(int v) {
		if(parent[v]==v) {	// root인지 검사
			return v;
		}
		// findSet(parent[v]) => root를 찾음
		parent[v] = findSet(parent[v]);	// path compression
		return parent[v];	// 부모의 root를 찾으러 감
	}
	
	/**
	 * 두 그래프 또는 노드를 병합하는 기능 
	 * @param u
	 * @param v
	 */
	public static void union(int u, int v) {
		parent[findSet(u)] = findSet(v);	// u를 v에다 합친다. v의 root값을 u의 root값 자리에 넣고 있다.
		// 두 그래프중 아무 그래프에 병합하면 편향트리가 될 수 있다.
		// => pass compression
	}
	
	public static void main(String[] args) {
		
		int N = 6;
		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			makeSet(i);
		}
		
		System.out.println(Arrays.toString(parent));
		union(4, 3);
		union(2, 3);
		union(6, 5);
		System.out.println(Arrays.toString(parent));

		System.out.println("(2,4) : "+(findSet(2)==findSet(4)));
		System.out.println("(2,6) : "+(findSet(2)==findSet(6)));
	}

}
