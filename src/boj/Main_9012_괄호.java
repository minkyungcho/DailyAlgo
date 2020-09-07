package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        Stack<Character> s;
        for (int i = 0; i < T; i++) {
        	s = new Stack<>();
        	String str = br.readLine();
        	String result = "YES";
        	for (int j = 0; j < str.length(); j++) {
        		if(str.charAt(j)=='(') {
        			s.push(str.charAt(j));
        			continue;
        		}
        		if(str.charAt(j)==')') {
        			if(!s.isEmpty() && s.peek()=='(') {
        				s.pop();
        			}else {
        				result = "NO";
        			}
        		}
			}
        	if(!s.isEmpty()) result = "NO";
        	sb.append(result+"\n");
        }
        System.out.print(sb);
	}

}
