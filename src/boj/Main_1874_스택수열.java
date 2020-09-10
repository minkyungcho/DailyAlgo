package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String ans = "NO";
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> s = new Stack<>();
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			int first = arr[n];
			for (int i = cnt; i < first; i++) {
				s.push(++cnt);
				sb.append("+\n");
			}
			
			if(s.pop() != first) {
				sb.setLength(0);
				break;
			}
			
			sb.append("-\n");
		}
		if(sb.length() == 0) {
			System.out.println(ans);
		}else {
			System.out.println(sb);
		}
	}

}
