package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append('<');
		int first = 0; 
		while(!q.isEmpty()) {
			if(q.size()==1) {
				sb.append(q.poll());
			}else {
				for (int i = 0; i < K-1; i++) {
					first = q.poll();
					q.offer(first);
					
				}
				sb.append(q.poll()+", ");
			}
		}
		
		sb.append('>');
		System.out.println(sb);
	}

}
