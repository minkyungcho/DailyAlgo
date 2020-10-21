package top.QueueAndStack;

import java.util.Stack;

public class P01BaseBallGame {

	public static void main(String[] args) {
		
		String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
		System.out.println(points(strs));
		
	}
	
	public static int points(String[] strs) {
		
		// 1.
		Stack<Integer> stack = new Stack<>();
		
		// 2.
		for(String s:strs) {
			switch (s) {
			case "C":
				stack.pop();
				break;
			case "D":
				stack.push(2*stack.peek());
				break;
			case "+":
				int first = stack.pop();
				int second = stack.pop();
				stack.push(second);
				stack.push(first);
				stack.push(first + second);
				break;
			default:
				stack.push(Integer.parseInt(s));
				break;
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		return sum;
	}

}
