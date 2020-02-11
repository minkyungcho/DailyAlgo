package com.ssafy.stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호 검사
 * - 괄호 짝이 맞으면 OK, 짝이 맞지 않으면 Error를 출력
 * 
 * [입력]
 * 첫줄은 테스트케이스(T)
 * 두번째 줄부터 T개의 문자열이 입력됨.
 * 
 * [출력]
 * #테스트케이스 결과
 */
public class BleketTest_T {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/lecture/breket.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String tmp = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		String lines;
		for(int testCase=1; testCase<T+1; testCase++) {
			String result = "OK";
			lines = sc.nextLine();
			for(int i=0; i<lines.length(); i++) {
				char bleket = lines.charAt(i);
				
				if(bleket == '(') {
					stack.push(bleket);
//					System.out.println("( push");
				} else if(bleket == ')') {
					if(stack.isEmpty() || stack.pop()!='(') {
						result = "Error";
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				result = "Error";
			}
			stack.clear();
			System.out.println("#"+testCase+" "+result);
		}
		
	}

}
