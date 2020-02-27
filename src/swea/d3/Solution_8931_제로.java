package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_8931_제로 {
	
	static int T;
	static int N;
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/8931_제로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			result = 0;
			
			N = Integer.parseInt(br.readLine());
			
			Stack<Integer> s = new Stack<Integer>();
			
			for (int n = 0; n < N; n++) {
				int in = Integer.parseInt(br.readLine());
				if(in==0) {
					int pop = s.pop();
					result -= pop;
				}else {
					s.push(in);
					result += in;
				}
			}
			
			
			System.out.println("#"+testcase+" "+result);
		}
	}
}
