package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17299_오등큰수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 수열 a 
		int[] F = new int[1000001]; // 빈도수열 F
		int[] NGE = new int[N]; // 정답수열 NGE 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			F[arr[i]]++;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for (int i = 1; i < N; i++) {
			if(s.isEmpty()) {
				s.push(i);
			}
			while(!s.isEmpty() && F[arr[s.peek()]] < F[arr[i]]) {
				NGE[s.peek()] = arr[i];
				s.pop();
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			NGE[s.peek()] = -1;
			s.pop();
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(NGE[i]+" ");
		}
		
		System.out.println(sb);
	}

}
