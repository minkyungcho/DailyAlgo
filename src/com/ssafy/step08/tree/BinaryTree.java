package com.ssafy.step08.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	public BinaryTree(int size) {
		nodes = new Object[size+1];
		this.SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(Object e) { // 완전이진트리로 채움 
		if(isFull()) {
			System.out.println("포화상태");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void searchPreOrder(int index) { // VLR
		if(index <= lastIndex) {
			System.out.print(nodes[index]+" "); // V
			searchPreOrder(index*2); // L
			searchPreOrder(index*2+1); // R
		}
	}
	public void searchInOrder(int index) { // LVR
		if(index <= lastIndex) {
			searchInOrder(index*2); // L
			System.out.print(nodes[index]+" "); // V
			searchInOrder(index*2+1); // R
		}
	}
	public void searchPostOrder(int index) { // LRV
		if(index <= lastIndex) {
			searchPostOrder(index*2); // L
			searchPostOrder(index*2+1); // R
			System.out.print(nodes[index]+" "); // V
		}
	}
	
	public void searchBFS() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(nodes[cur]+" ");
			
			if(cur*2<=lastIndex) queue.offer(cur*2);
			if(cur*2+1<=lastIndex) queue.offer(cur*2+1);
			
		}
		System.out.println();
	}

	public void searchBFS2() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 
		while(!queue.isEmpty()) {
			int size = queue.size();

			while(size-- > 0) {
				int cur = queue.poll();
				
				System.out.print(nodes[cur]+" ");
				if(cur*2<=lastIndex) queue.offer(cur*2);
				if(cur*2+1<=lastIndex) queue.offer(cur*2+1);
				
			}
			System.out.println();
		}
	}
	
}
