package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_T_NextPermutation {

	static int N, p[]; // N:고객집의 수, p:고객집의 순서를 만들 순열용 배열  
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] customers = new int[N][2]; // N명의 고객집 좌표 
			int[][] distance = new int[N+2][2]; // 회사 좌표()), N명의 고객좌표(순열로 순서결정:1-N), 집 좌표(N+1)
			p = new int[N];
			int min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			distance[0][0] = Integer.parseInt(st.nextToken()); // 회사 
			distance[0][1] = Integer.parseInt(st.nextToken());
			distance[N+1][0] = Integer.parseInt(st.nextToken()); // 집 
			distance[N+1][1] = Integer.parseInt(st.nextToken());
			
			// 고객집 좌표 
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
				p[i] = i+1; // 첫번째 집은 1, 두번째 집은 2, ... N번째 집은 N. index 정해주기 
			}
			// p배열 = {1,2,3,4,5}
			// np 호출 => 1,2,3,5,4
			// np 호출 => 1,2,4,3,5
			
			do {
				// 순열로 처리 
				for (int i = 0; i < N; i++) {
					distance[p[i]] = customers[i];
				}
				int temp = 0;
				for (int i = 0; i <= N; i++) { // 앞집부터 뒷집(인접한 두 집 처리)
					temp += Math.abs(distance[i][0] - distance[i+1][0]);
					temp += Math.abs(distance[i][1] - distance[i+1][1]);
				}
				// 최소값 갱신 
				if(min>temp) {
					min = temp;
				}
			}while(nextPermutation());
			
			System.out.println("#"+tc+" "+min);
			
		}
		
	}

	// boolean : true -> 다음 순열 생성 ok, false -> 다음 순열 생성 불가(이미 제일 큰 순열 )
	static boolean nextPermutation() {
		// 1. 뒤쪽부터 탐색하며 꼭대기(i) 찾기 : i-1=>교환위치 
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false; // 이미 제일 큰 마지막 순열이므로 다음 순열 없음 
		
		// 2. 뒤쪽부터 탐색하며 교환할 큰값(j) 찾기
		int j = N-1;
		while(p[i-1]>=p[j]) --j;
		
		// 3. i-1, j 위치값 교환 
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		// 4. i위치부터 N-1(맨뒤)까지 내림차순형태의 숫자를 오름차순으로 가장 작은수로 만들기 위해 교환 
		int k = N-1;
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
