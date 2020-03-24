package com.ssafy.stack;

import java.util.Stack;

public class S02_PostExpressionTest {

	public static void main(String[] args) {
		
		String expression = "6528-*2/+";
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.println(expression);

		int size = expression.length();
		for (int i = 0; i < size; i++) {
			char temp = expression.charAt(i);
			if(Character.isDigit(temp)) { // 피연산자 
				s.push(temp-'0');
			} else { // 연산자 
				int val2 = s.pop(); // 두번째 피연산자 
				int val1 = s.pop(); // 첫번째 피연산자
				switch(temp) {
				case '+':
					s.push(val1+val2);
					break;
				case '-':
					s.push(val1-val2);
					break;
				case '*':
					s.push(val1*val2);
					break;
				case '/':
					s.push(val1/val2);
					break;
				}
			}
		} // end for 
		System.out.println(s.pop());
	}

}
