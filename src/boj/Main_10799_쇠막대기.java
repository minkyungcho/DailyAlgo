package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799_쇠막대기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		Stack<Character> s = new Stack<>();
		char c = input.charAt(0);
		s.add(c);
		char before;
		int cnt = 0;
		int num = 0;
		if(c=='(') cnt = 1;
		for (int i = 1; i < input.length(); i++) {
			c = input.charAt(i);
			before = input.charAt(i-1);
			if(c == '(') {
				s.add(c);
				cnt++;
			}else {
				if(before=='(') {
					s.pop();
					cnt--;
					num += cnt;
				}else {
//					if(s.peek()=='(') {
						s.pop();
						num++; 
						cnt--;
//					}
				}
			}
		}
		System.out.println(num);
	}

}
