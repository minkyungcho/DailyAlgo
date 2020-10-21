package top.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P02MergeKSortedLists {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
		}
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] list = new ListNode[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		
		P02MergeKSortedLists a = new P02MergeKSortedLists();
		ListNode result = a.mergeKLists(list);

		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] list) {
		
		// 1.
		Queue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		for(ListNode node:list) {
			if(node != null) {
				queue.offer(node);
			}
		}
		
		// 2.
		while(!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if(node.next != null) {
				queue.offer(node.next);
			}
		}
		
		return newHead.next;
	}

	static Comparator<ListNode> Comp = new Comparator<ListNode>() {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
		
	};
}
