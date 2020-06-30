package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		// 정렬 
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2],o2[2]);
			}
		});
		// union find
		parents = new int[V+1]; // 정점1부터 시작!!!! 
		rank = new int[V+1];
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		int cnt = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a == b) continue;
			// 간선 선택 
			result += edges[i][2];
			union(a, b);
			
			//정점 갯수-1 만큼 반복하면 종료  
			cnt++;
			if(cnt == V-1) {
				break;
			}
		}
		
		System.out.println(result);
	}
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
