package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {

	static int N,M,C; // N : 벌통크키, M : 연속된벌통수, C : 채취량 
	static int[][] map, maxMap; // map : 입력된 벌통정보,
								// maxMap : i,j 위치에서 가질 수 있는 최대이익
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/2115_벌꿀채취.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N]; // 0으로 초기화 
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			// 1. 각 i,j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			
			// 2. 두 일꾼의 조합
			System.out.println("#"+t+" "+getMaxBenefit());
			
		}
		
	} // end main
	
	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	
	/*
	 * i : 행위
	 * j : 열위치
	 * cnt : 고려한원소수
	 * sum : 부분집합에 속한 원소의 
	 * powSum : 부분집합에 속한 원소의 이
	 */
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		
		if(sum>C) return; // 부분집합의 합이 목표량 C를 초과하면 그 다음은 볼 필요 없어 return. 
		// 기저 조건 M개 원소 부분집합 
		if(cnt==M) {
			// 0,0  M=2
			// 0,0:0   0,1:1   0,2:2
			if(maxMap[i][j-M]<powSum) {
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		
		// i,j 위치 원소 선택
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
		
		// i,j 위치 원소 비선택 
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);
	}
	
	private static int getMaxBenefit() {
		
		int max = 0, tmp = 0; // max :조합적 선택후의 최대이익값
		// 1. 일꾼A 기준 선택 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) { // 일꾼A  
				// 2. 일꾼B 기준 선택 
				// 같은 행 기준 선택 
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					tmp = maxMap[i][j] + maxMap[i][j2];
					if(max < tmp) {
						max = tmp;
					}
				}
				// 다음행부터 마지막행까지 선택 
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N-M+1; j2++) {
						tmp = maxMap[i][j] + maxMap[i2][j2];
						if(max < tmp) {
							max = tmp;
						}
					}
				}
			}
		}
		return max;
	}
}
