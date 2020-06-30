package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청 {
	
	static int T;
	static int N, K;
	static int result;
	static int[] num;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/6719_성수의프로그래밍강좌시청.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			num = new int[N];
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			
			
			
			System.out.println("#"+t +" "+result);
		}
		
	}

}
