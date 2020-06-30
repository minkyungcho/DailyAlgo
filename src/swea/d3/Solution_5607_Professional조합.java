package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_Professional조합 {
	
	static int T, N, R;
	static long result;
	static long[] fac;
	static final int MOD = 1234567891;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/5607_Professional조합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			fac = new long[N+1];
			
			fac[0] = 1;
			for (int i = 1; i < N+1; i++) {
				fac[i] = (fac[i-1]*i)%MOD;
			}
			
			long bottom = (fac[R]*fac[N-R])%MOD;
			long reBottom = dq(bottom, MOD-2);
			
			result = (fac[N]*reBottom)%MOD;
			System.out.println("#"+t+" "+result);
		}
		
	}

	private static long dq(long n, int x) {
		if(x==0) return 1;
		long temp = dq(n,x/2);
		long ret = (temp*temp)%MOD;
		if(x%2==0) return ret;
		else return (ret*n)%MOD;
	}

}
