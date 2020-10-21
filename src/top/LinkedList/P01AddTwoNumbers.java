package top.LinkedList;

public class P01AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		
		ListNode node = solve(l1, l2);
		
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode solve(ListNode l1, ListNode l2) {
		// 1.
		// 더미 데이터 만들기 
		ListNode newHead = new ListNode(0);
		
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = newHead;
		
		int carry = 0; // 6 + 4 = 10
		
		// 2. 
		while(p1!=null || p2!=null) {
			if(p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry%10);
			p3 = p3.next;
			carry /= 10;
		}
		if(carry == 1) {
			p3.next = new ListNode(1);
		}
		return newHead.next;
	}

}
