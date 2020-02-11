package jungol.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날_stack {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/im/1141_불쾌한날.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long cnt = 0;
		// 현재 소를 볼 수 있는 소들만 담아 놓기
		Stack<Integer> stack= new Stack<>();

		for(int i=0; i<n; i++) {
			int cow = sc.nextInt();
			// 현재 소를 볼 수 없는 (작거나 같은 키의 소)는 모두 뺀다.
			while(!stack.isEmpty() && stack.peek()<=cow) {
				stack.pop();
			} 
			cnt += stack.size(); // 남아 있는 소는 모두 현재 소를 볼 수 있는 소들
			stack.push(cow);
		}
		System.out.println(cnt);
		
	}

}
