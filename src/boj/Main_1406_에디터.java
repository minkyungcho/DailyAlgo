package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> cursorLeft = new Stack<>();
		Stack<Character> cursorRight = new Stack<>();
		
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			cursorLeft.push(input.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			switch (first) {
			case "L":
				if(!cursorLeft.isEmpty())
					cursorRight.push(cursorLeft.pop());
				break;
			case "D":
				if(!cursorRight.isEmpty())
					cursorLeft.push(cursorRight.pop());
				break;
			case "B":
				if(!cursorLeft.isEmpty()) {
					cursorLeft.pop();
				}
				break;
			case "P":
				String second = st.nextToken();
				cursorLeft.push(second.charAt(0));
				break;
			}
		}
		
		while(!cursorLeft.isEmpty()) {
			cursorRight.push(cursorLeft.pop());
		}
		while(!cursorRight.isEmpty()) {
			sb.append(cursorRight.pop());
		}
		System.out.println(sb);
	}

}
/*
abcd
3
P x
L
P y

abc
9
L
L
L
L
L
P x
L
B
P y

dmih
11
B
B
P x
L
B
B
B
P y
D
D
P z
*/
