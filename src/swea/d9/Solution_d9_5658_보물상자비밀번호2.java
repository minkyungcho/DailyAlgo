package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_d9_5658_보물상자비밀번호2 {
	
	static int N, K;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d9/5658_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 4의 배수 8<=N<=28
			K = Integer.parseInt(st.nextToken()); // K번째 큰수 
			String s = br.readLine();
			String t = s + s.substring(0, N/4-1);
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String hex = t.substring(i, i+N/4);
				int num = Integer.parseInt(hex, 16);
				if(!list.contains(num)) {
					list.add(num);
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#"+tc+" "+list.get(K-1));
			
		}
	}
}
