package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

	static int N, M;
	static int ans;
	static boolean[][] graph;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/5643_키순서.txt"));
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 학생 
			M = Integer.parseInt(br.readLine()); // 비교 횟수 
			graph = new boolean[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a->b : a는 b보다 작다. 
				graph[a][b] = true;
			}
			
			// 모든 정점 연결 확인 
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(graph[i][k] && graph[k][j]) { // i->k , k->j
							graph[i][j] = true; // i->j
						}
					}
				}
			}
			
			// 키 순서 아는 녀석 몇명인지.
			ans = 0; 
			for (int i = 1; i <= N; i++) {
				int cnt = 0; // 나와 연결된 정점 개수 
				for (int j = 1; j <= N; j++) {
					if(i==j) continue; // 나는 제외 
					if(graph[i][j] || graph[j][i]) { // 나를 가리키거나 내가 가리키거나 
						cnt++;
					}
				}
				// 나를 기준으로 모든 정점과의 연결상태 확인하고 나서
				// 모든 정점과 연결되어 있다면 나의 키 순서 알 수 있음.
				if(cnt == N-1) {
					ans++;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}

	}

}
