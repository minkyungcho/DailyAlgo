package com.ssafy.stack;

import java.util.Stack;

public class S01_StackAPITest {

	public static void main(String[] args) {
		
		Stack<String> s = new Stack<String>(); // 공백 스택 생성 
		s.push("김태희");
		s.push("이동욱");
		s.push("이지아");
		
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
		
	}

}
