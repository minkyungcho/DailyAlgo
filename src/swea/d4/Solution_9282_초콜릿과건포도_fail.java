package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도_fail {

	static int result;
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/9282_초콜릿과건포도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t < TC+1; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 사이즈 정해져 있으
			// 처리
			result = dfs(0,0,n,m, Integer.MAX_VALUE);
			
			// 출력 
			System.out.println("#"+t+" "+result);
		}
	}

	private static int dfs(int y, int x, int h, int w, int min) {
		// 종료 
		if(w==1 && h==1) { // 단일조각일때는 종료 
			return 0;
		}
		
		// 실행 
		// 기존에 있던 덩어리의 건포도의 개수 
		int sum = 0;
		for (int i = y; i < y+h; i++) {
			for (int j = x; j < x+w; j++) {
				sum += map[i][j];
			}
		}
		
		// 재귀호출 
		// 가로로 나누어서 비용을(최소비용) 구한다.
		for (int i = 1; i < h; i++) {
			// 위쪽에 대한 비용
			int sum1 = dfs(y, x, i, w, min);
			// 아래쪽에 대한 비용
			int sum2 = dfs(y+i, x, h-i, w, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		// 세로로 나누어서 비용을(최소비용) 구한다.
		for (int i = 1; i < w; i++) {
			// 왼쪽에 대한 비용
			int sum1 = dfs(y, x, h, i, min);
			// 오른쪽에 대한 비용
			int sum2 = dfs(y, x+i, h, w-i, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		return min;
	}

}
