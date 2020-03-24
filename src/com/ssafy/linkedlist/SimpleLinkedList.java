package com.ssafy.linkedlist;

public class SimpleLinkedList {
	
	static class Node{
		Object data;
		Node link;
		
		public Node(Object data) {
			this.data = data;
		}
		
		public Node(Object data, Node link) {
			this.data = data;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
		
	}
	
	private Node head; // 첫노드 자신 
	
	// 앞으로 삽입하는 함수 
	public void addFirstNode(Object data) {
		head = new Node(data, head); // head가 첫번째 노드 가리키고 있었음 
	}
	
	// 전체 탐색하면서 원하는 노드 찾기 
	public Node getNode(Object data) {
		Node curNode = head;
		while(curNode != null) {
			if(curNode.data.equals(data)) {
				return curNode;
			}
			curNode = curNode.link; // 현재노드를 현재노드가 가리키고 있는 링크(다음노드)로 대체해준다.  
		}
		return null;
	}
	
	// 전체를 출력하는 기능 
	public void printList() {
		Node curNode = head;
		while(curNode != null) {
			System.out.print(curNode.data+" ");
			curNode = curNode.link; // 현재노드를 현재노드가 가리키고 있는 링크(다음노드)로 대체해준다.  
		}
		System.out.println();
	}

}
