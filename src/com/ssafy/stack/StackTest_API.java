package com.ssafy.stack;

import java.util.Stack;

public class StackTest_API {

	public static void main(String[] args) {
		/**
		 * - 자료구조에 "< >"를 적용하면 특정 타입만 저장하도록 지정
		 * - API로 제공하는 자료구조는 객체만 저장
		 * - API로 제공하는 자료구조는 toString()를 구현했고
		 *   저장된 자료를 문자열로 리턴
		 */
		Stack<String> stack = new Stack<>();
		
		// isEmpty() : stack이 비어있으면 true, 저장되어 있으면 false
		System.out.println(stack.isEmpty());
		
		// push(~) : 마지막에 추가하는 기능
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack);
		System.out.println(stack.isEmpty());

		// size() : 자료가 저장된 갸수
		System.out.println("저장된 개수 : "+stack.size());
		
		// contains(데이터) : 해당 데이터가 저장되어 있으면 true, 없으면 false
		System.out.println(stack.contains("3"));
		
		// peek(), pop() 함수는 데이터가 없는 경우 EmptyStackException 에러 발생한다.
		// peek() : 맨 마지막 데이터를 추출 (제거하지 않는다)
		System.out.println(stack.peek());
		System.out.println(stack.peek());

		// pop() : 맨 마지막 데이터를 추출하고 저장소에서 제거한다.
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
		
		// clear() : 저장소의 자료를 모두 비우기
		stack.clear();
		System.out.println(stack);
		
	}

}
