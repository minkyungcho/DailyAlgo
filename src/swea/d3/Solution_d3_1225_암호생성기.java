package swea.d3;
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
public class Solution_d3_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/1225_암호생성기2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int testcase=1; testcase<T+1; testcase++) {
			int tmp = Integer.parseInt(sc.next());
			String t = sc.nextLine();

			// queue에 데이터 넣기
			for(int i=0; i<8; i++) {
				queue.offer(sc.nextInt());
			}
			
			out:
			while(true) {
				// 5번 주기로 싸이클 돈다
				for(int j=1; j<6; j++) {
					// 앞에 데이터 뒤로 보내기 peek, poll, offer
					int first = queue.poll();
					first -= j;
					
					// offer 할때 숫자가 0이면 암호 도출.
					if(first<=0) {
						first = 0;
						queue.offer(first);
						
						System.out.print("#"+testcase+" ");
						for(int q : queue) {
							System.out.print(q+" ");
						}
						System.out.println();
						queue.clear();
						break out;
					}
					queue.offer(first);
				}
			}
		}
	}
}
