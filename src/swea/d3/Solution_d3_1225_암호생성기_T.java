package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution_d3_1225_암호생성기_T {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int T = 10;
		System.setIn(new FileInputStream("res/swea/d3/1225_암호생성기2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = 8;
		for (int testcase = 1; testcase <= T; testcase++) {
			
			sc.nextInt();
			for(int i=0; i<N; i++) {
				queue.offer(sc.nextInt());
			}
			
			boolean isDone = false;
			top:
			while(!isDone) {
				for (int i = 1; i <= 5 ; i++) {
					int num = queue.poll()-i;
					if(num<=0) {
						num=0;
						isDone = true;
					}
					queue.offer(num);
					if(isDone) {
						break top;
					}
				}
			}
			System.out.print("#"+testcase+" ");
			for(Integer n : queue) {
				System.out.print(n+" ");
			}
			System.out.println();
			queue.clear();
		}
	}

}
