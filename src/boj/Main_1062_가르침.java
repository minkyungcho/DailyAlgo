package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	
	static int N, K;
	static boolean[][] word;
	static boolean[] visit;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new boolean[N][26];
		for (int i = 0; i < N; i++) {
			String s = br.readLine(); 
			int len = s.length();
			for (int j = 0; j < len; j++) {
				int n = s.charAt(j)-'a';
				word[i][n] = true;
			}
		}	
		visit = new boolean[26];
		ans = 0;
		solve(0,0);
		System.out.println(ans);
		
	}

	private static void solve(int idx, int cnt) {
		if(cnt == K) {
			check();
			return;
		}
		for (int i = idx; i < 26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				solve(i, cnt+1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		int ret = 0;
		boolean flag = true;
		for (int n = 0; n < N; n++) {
			flag = true;
			for (int i = 0; i < 26; i++) {
				if(word[n][i] && !visit[i]) { // 단어에있는알파벳이 && 배울수 있는 알파벳이 아니면(방문 안했는데)  
					flag = false;
					break;
				}
			}
			if(flag) ret++; // 단어알파벳이랑 배운알파벳이랑 모두 같은경우 
		}
		ans = Math.max(ans, ret);
	}

}
