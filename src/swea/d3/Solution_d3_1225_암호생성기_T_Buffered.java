package swea.d3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Solution_d3_1225_암호생성기_T_Buffered {
	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int T = 10;
		System.setIn(new FileInputStream("res/swea/d3/1225_암호생성기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 8;
		for (int testcase = 1; testcase <= T; testcase++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
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
