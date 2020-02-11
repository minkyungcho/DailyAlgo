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
public class BleketTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/lecture/breket.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String tmp = sc.nextLine();
		for(int testCase=1; testCase<T+1; testCase++) {
			String result = null;
			char[] input = sc.nextLine().toCharArray();
			int len = input.length;
			System.out.println(Arrays.toString(input));
//			System.out.println(input.length);
			

			Stack<Character> stack = new Stack<>();
			for(int i=0; i<len; i++) {
				
//				System.out.println("input:"+input+".");
				if(input[i]=='(') {
					stack.push(input[i]);
					System.out.println("( push");
				}else if(input[i]==' ') {
					System.out.println("공백이야");
					continue;
				}else if(input[i]==')') {
					if(stack.isEmpty()) {
						result = "Error";
						break;
					}else {
						stack.pop();
						System.out.println("( pop");
					}
				}
				System.out.println(stack);
				
			}
			if(!stack.isEmpty()) {
				result = "Error";
			}else {
				result = "OK";
				
			}
			System.out.println("#"+testCase+" "+result);
		}
		
	}

}
