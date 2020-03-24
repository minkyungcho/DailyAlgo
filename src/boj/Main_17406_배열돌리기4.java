package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	
	static int N, M, K, MIN;
	static int[][] map, original, command;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		original = new int[N][M];
		command = new int[K][3];
		MIN = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] p = new int[K]; // K:3 ==> 0 0 0
		// 0 1 2
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			command[i][0] = Integer.parseInt(st.nextToken())-1;
			command[i][1] = Integer.parseInt(st.nextToken())-1;
			command[i][2] = Integer.parseInt(st.nextToken());
			p[i] = i;
		}
		
		do {
			// 0. 직전에 회전한 배열의 생태를 초기상태로 초기화 
			for (int i = 0; i < N; i++) {
				System.arraycopy(original[i], 0, map[i], 0, M);
			}
			
			// 1. 현 순열의 상태로 회전 (순서대로 K번)
			for (int i = 0; i < K; i++) {
				int k = p[i];
				rotate(command[k][0], command[k][1], command[k][2]);
			}
			
			// 2. 배열의 값을 구함.
			int temp = getMin(); // 현재 map을 가지고 각 배열의 합의 최소값을 구함 
			
			// 3. 최소값 갱신 
			if(MIN>temp) MIN = temp;
			
		}while(np(p));
		System.out.println(MIN);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
	}

	private static int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			if(min>sum) min = sum;
		}
		return min;
	}
	
	private static void rotate(int r, int c, int s) {
		
		for (int k = s; k > 0 ; k--) {
			int start = map[r-k][c-k];
			
			// 맨 왼쪽열 아래에서 위로 
			// ^
			// |
			for (int i = r-k; i < r+k; i++) {
				map[i][c-k] = map[i+1][c-k];
			}
			
			// 맨 아래행 오른쪽에서 왼쪽으로 
			// <--
			for (int j = c-k; j < c+k; j++) {
				map[r+k][j] = map[r+k][j+1];
			}
			
			// 맨 오른쪽열 위에서 아래로 
			// |
			// v
			for (int i = r+k; i > r-k; i--) {
				map[i][c+k] = map[i-1][c+k];
			}
			
			// 맨 윗행 왼쪽에서 오른쪽으로 
			// -->
			for (int j = c+k; j > c-k; j--) {
				map[r-k][j] = map[r-k][j-1];
			}
			
			map[r-k][c-k+1] = start; 
		}
		
		
	}

	/*
	 * Next Permutation 
	 */
	public static boolean np(int[] p) {
		
		// 찾 찾 교 교 
		// 1. 꼭대기(i) 찾기 ==> i-1 위치 찾기(교환 자리)
		int i = K-1; // p.length -1
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false;
		
		// 2. i-1 위치값과 교환할 j 위치 찾기 
		int j = p.length-1;
		while(p[i-1]>=p[j]) --j;
		// i-1보다 큰 j 를 찾아서 while문 빠져나옴 
		
		// 3. i-1 위치값과 j 위치값 교환 
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		// 4. i  -  끝까지 오름차순으로 교환 
		int k = p.length-1;
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		
		return true; 
	}
	
}


/*
 * 입력으로 들어오는 회전명령을 순열로 모든 경우를 다 고려 
 * 1. 회전 (순열로 구해진 순서대로 차례대로 회전)
 * 2. 회전 후 각 행의 최소값을 구하여 배열의 값을 구한다. 
 * ==> 각행의 최소값 중 최소값 
 */
