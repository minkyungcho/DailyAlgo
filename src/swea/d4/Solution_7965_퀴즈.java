package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_7965_퀴즈 {
	
	static int T;
	static int N;
	static long result;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/7965_퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			
			result = 0;
			N = Integer.parseInt(br.readLine());
			
			for (int i = 1; i < N+1; i++) {
				result += dcPower(i, i);
			}
			
			System.out.println("#"+testcase+" "+result%1000000007);
		}
		
	}
	public static long dcPower(int x, int n){
		if(n==1) {
			return x;
		}
		if(n==0) {
			return 1;
		}
		long ret = dcPower(x, n>>1);
		if(n%2==0) {
			return ret*ret%1000000007;
		}else {
			return ((ret*ret)%1000000007)*x%1000000007;
		}
	}

}
