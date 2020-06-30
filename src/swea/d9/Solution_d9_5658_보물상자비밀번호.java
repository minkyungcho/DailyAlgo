package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_d9_5658_보물상자비밀번호 {
	
	static int N, K;
	static char[] strarr;
	static String str;
	static String[] lock;
	static PriorityQueue<Integer> q;
	static StringBuilder sb;
	static int length;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d9/5658_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			length = N/4;
			lock = new String[N];
			strarr = br.readLine().toCharArray();
			q = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				lock[i] = strarr[i]+"";
			}
			
			for (int i = 0; i < 3; i++) {
				getNumber();
				rotate();
			}
			
		}
	}
	
	private static void rotate() {
		String temp = lock[N-1];
		for (int i = N-1; i > 0 ; i--) {
			lock[i] = lock[i-1];
		}
		lock[0] = temp; 
	}
	
	private static void getNumber() {
		for (int i = 0; i < N; i++) {
			sb = new StringBuilder();
			sb.append(lock[i]);
			if(i%length==0) {
				System.out.println(sb.toString());
				q.add(Integer.parseInt(sb.toString(), 16));
			}
		}
	}
}
