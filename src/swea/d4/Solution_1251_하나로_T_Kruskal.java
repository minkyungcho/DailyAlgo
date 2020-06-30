package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로_T_Kruskal {
	
	static int[] parents;
	static int[] rank;
	
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
	
	static int T;
	static int N; // 섬 
	static double E; // 환경부담 세율   
	static int[][] islands; // 섬 좌표 담고 있는 배열 
	static double result;
	static long[][] graph; // 정점들 간의 거리 그래프 
	
	static class Edges implements Comparable<Edges>{
		int v1;
		int v2;
		long cost;
		public Edges(int v1, int v2, long cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edges o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stR,stC;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			islands = new int[N][2]; 
			stR = new StringTokenizer(br.readLine(), " ");
			stC = new StringTokenizer(br.readLine(), " ");
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i] = new int[] {Integer.parseInt(stR.nextToken()), Integer.parseInt(stC.nextToken())};
			}
			
			// 정점1 정점2 가중치 
			Edges[] edges = new Edges[N*(N-1)/2];
			int cnt = 0;
			for (int i = 0; i < N-1; i++) { // 마지막 한번은 돌지 않아도 된다. 다른 친구들이 다 나 를 방문했기때문 
				for (int j = i+1; j < N; j++) {
					edges[cnt] = new Edges(i, j, dist(islands[i][0], islands[j][0], islands[i][1], islands[j][1]));
					cnt++;
				}
			}
			
			// 정렬 
			Arrays.sort(edges);
			// union find
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			long result = 0;
			cnt = 0;
			
			for (int i = 0; i < N*(N-1)/2; i++) {
				int v1 = findSet(edges[i].v1);
				int v2 = findSet(edges[i].v2);
				if(v1 == v2) {
					continue;
				}
				result += edges[i].cost;
				union(v1, v2);
				cnt++;
				if(cnt == N-1) break;
			}
			
			System.out.println("#"+tc+" "+Math.round(result*E));
			
//			if(tc == 2) break;
		}
		
	}
	static long dist(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
}
