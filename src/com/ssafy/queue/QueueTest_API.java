package com.ssafy.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest_API {

	public static void main(String[] args) {
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		System.out.println(queue);
		System.out.println(queue.isEmpty());
		
		
		/**
		 * 데이터 추가 
		 * offer()
		 */
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue);

		/**
		 * 데이터가 저장되어 있으면 true, 저장되어 있지 않으면 false
		 * contains()
		 */
		System.out.println(queue.contains(3));
		
		/**
		 * 데이터 추출
		 * peek()
		 */
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		
		/**
		 * 데이터 제거한 후에 추출
		 * poll()
		 */
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		
	
	}

}
