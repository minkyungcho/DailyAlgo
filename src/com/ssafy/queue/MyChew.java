package com.ssafy.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;



public class MyChew {
	
	public static void main(String[] args) {
		
		ArrayDeque<Integer> p = new ArrayDeque<>();
		ArrayDeque<Integer> n = new ArrayDeque<>();
		
		int max = 10;
		
		int cnt = 20;
		int i=1;
		int num=1;
		out:
		for(i=1; i<max; i++) {
			for(num=1; num<=i; num++) {
				p.offer(i);
				n.offer(num);
				
				while(!p.isEmpty()) {
					int pp = p.peek();
					int nn = n.peek();
					System.out.println(p.peek()+" "+n.peek());
					cnt -= n.peek();
					System.out.println("남은마이쭈:"+cnt);
					p.poll();
					n.poll();
					nn++;
					p.offer(pp);
					n.offer(nn);
					if(cnt==0) {
						System.out.println("다먹엇음");
						break out;
					}
				}
				
			}
			if(cnt == 0) {
				System.out.println("마이쮸 다먹음");
				break;
			}
		}
		
		
		
		
//		Queue<Integer> q = new Queue
		
		
	}

}
