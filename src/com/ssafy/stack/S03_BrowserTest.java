package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S03_BrowserTest {
	
	/**
	 * Visit : 현재 페이지를 B stack에 push, F stack clear 
	 * Back : 현재 페이지를 F stack에 push, B stack pop 후 현재페이지로 설정 
	 * Foward : 현재 페이지를 B stack에 push, F stack pop 후 현재페이지로 설정  
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String current = "http://www.ssafy.com";
		Stack<String> bStack = new Stack<String>();
		Stack<String> fStack = new Stack<String>();
		
		while(true) {
			String input = br.readLine();
			if(input.charAt(0) == 'Q') {
				break;
			}
			st = new StringTokenizer(input, " ");
			switch(st.nextToken().charAt(0)) {
			// V	http://www.naver.com
			// B	http://www.naver.com
			
			case 'V':
				fStack.clear();
				bStack.push(current);
				current = st.nextToken(); // url
				System.out.println(current);
				break;
			case 'B':
				if(bStack.isEmpty()) {
					System.out.println("Ignored...");
				}else {
					fStack.push(current);
					current = bStack.pop();
					System.out.println(current);
				}
				break;
			
			case 'F':
				if(fStack.isEmpty()) {
					System.out.println("Ignored...");
				}
				else {
					bStack.push(current);
					current = fStack.pop();
					System.out.println(current);
				}
				break;
			}
		}
		
	}

}
