package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	
	static int N, M;
	static Queue<Integer> q;
	static Queue<Integer> result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int[] indegree = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// v1 -> v2
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(v2);
			indegree[v2]++;
		}
		
		topologicalSort(indegree, list);
		
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
		
	}

	static void topologicalSort(int[] indegree, List<List<Integer>> list) {
		q = new LinkedList<>();
		result = new LinkedList<>();
		
		// indegree가 0인 애들 q에 넣어주기 
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		// q에서 하나씩 빼면서 indegree 1씩 감소.
		while(!q.isEmpty()) {
			int node = q.poll();
			// q에서 뺀 노드를 result 에 넣기 
			result.offer(node);
			
			for(Integer linked : list.get(node)) {
				// node와 연결된 linked의 indegree 감소. 
				indegree[linked]--;
				
				// indegree가 0인 애들 q에 넣어주기 
				if(indegree[linked] == 0) {
					q.offer(linked);
				}
			}
		}
		
		
	}

}
