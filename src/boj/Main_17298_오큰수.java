package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 수열 a 
		int[] NGE = new int[N]; // 정답수열 NGE 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<>(); // 인덱스 넣을 스택 
		s.push(0); // 인덱스 0부터 비교 
		
		for (int i = 1; i < N; i++) {
			// 스택에 수가 없으면 현재 위치를 스택에 넣는다
			if(s.isEmpty()) {
				s.push(i);
			}
			// 스택이 비어있지 않고, 스택 가장 위에 있는 수 arr[s.top()]보다 현재 수 arr[i]가 클때 오큰수를 찾음
			// NGE[s.top()]는 현재 수 arr[i]가 된다.
			while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
				NGE[s.peek()] = arr[i];
				s.pop(); // 오큰수 NGE 찾았으니 스택에서 뺀다. 
			}
			// 현재 위치를 스택에 넣는다.
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			// 오큰수 못찾으면 -1 
			NGE[s.peek()] = -1;
			s.pop();
		}
		
		// NGE 출력
		for (int i = 0; i < N; i++) {
			sb.append(NGE[i]+" ");
		}
		
		System.out.println(sb);
	}

}
