package swea.d4;

import java.util.Scanner;

public class Solution_달리기 {
	
	static int T,N,M;
	static int count;
	static int[] needs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t < T+1; t++) {
			count = 0;
			int f, s;
			N = sc.nextInt();
			M = sc.nextInt();
			needs = new int[N]; // f번째 들어온 사람들을 flag로 표현한것 
			for (int i = 0; i < M; i++) {
				f = sc.nextInt()-1;
				s = sc.nextInt()-1;
				needs[f] |= (1<<s);
			}
			dfs(0);
			
			System.out.println("#"+t+" "+count);
		}
		
	}

	private static void dfs(int flag) {
		if(flag==(1<<N)-1) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i)==0) {
				if((flag & needs[i])==needs[i]) {
					dfs(flag | 1<<i);
				}
			}
		}
		
		
	}

}
