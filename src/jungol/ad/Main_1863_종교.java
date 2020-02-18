package jungol.ad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1863_종교 {

	static int N;
	static int M;

	static int[] parent;
	static int[] depth;

	/**
	 * DisjointSet을 위한 배열을 초기화 - 모든 노드가 root로 초기화
	 */
	public static void makeSet(int v) {
		parent[v] = v;
	}

	/**
	 * 특정 노드의 root를 찾아 반환하는 기능
	 */
	public static int findSet(int v) {
		if (parent[v] == v) { // root인지 검사
			return v;
		}
		// findSet(parent[v]) => root를 찾음
		parent[v] = findSet(parent[v]); // path compression
		return parent[v]; // 부모의 root를 찾으러 감
	}

	/**
	 * 두 그래프 또는 노드를 병합하는 기능
	 * 
	 * @param u
	 * @param v
	 */
	public static void union(int u, int v) {
		int pu = findSet(u);
		int pv = findSet(v);
		
		if(depth[v] > depth[u]) {
			parent[pu] = pv;
		}else {
			parent[pv] = pu;
			if(depth[pu]==depth[pv]) {
				depth[pu]++;
			}
		}
		
//		parent[findSet(u)] = findSet(v); // u를 v에다 합친다. v의 root값을 u의 root값 자리에 넣고 있다.
		// 두 그래프중 아무 그래프에 병합하면 편향트리가 될 수 있다.
		// => pass compression
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/ad/1863_종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		// makeset
		parent = new int[N+1];
		depth = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			makeSet(i);
		}
		
		// union
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(b,a);
			
		}
		
		// count group
		for(int i=1; i<N+1; i++) {
			if(i == parent[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
