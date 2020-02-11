package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_9012_괄호 {

	static int T;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/9012_괄호.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
//		System.out.println(T);
		String tmp = sc.nextLine();
		
		Stack<Character> s = new Stack<>();
		
		for(int testcase=1; testcase<T+1; testcase++) {
			s.clear();
			String answer = "YES";
			String line = sc.nextLine();
//			System.out.println(line);
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
//				System.out.println(c);
				if(c=='(') {
					s.push(c);
//					System.out.println("Push "+s.toString());
				}else if(c==')') {
					if(!s.isEmpty()) {
						s.pop();
//						System.out.println("Pop"+s.toString());
					}else {
						answer = "NO";
						
					}
				}
				
			}
			
			if(!s.isEmpty()) {
				answer = "NO";
			}
			
			System.out.println("#"+testcase+" "+answer);
		}
	}

}
