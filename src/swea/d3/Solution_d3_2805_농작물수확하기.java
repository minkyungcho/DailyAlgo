package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_2805_농작물수확하기 {
	
	static int T;
	static int N;
	static int sum;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/2805_농작물수확하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<T+1; test_case++) {
			sum = 0;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			String[] tmp = new String[N];
			for(int i=0; i<N; i++) {
				tmp = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			// 위 삼각형
			for(int i=0; i<N/2; i++) {
				for(int j=N/2-i; j<N/2+i+1; j++) {
//					System.out.print(map[i][j]+" ");
					sum+=map[i][j];
				}
//				System.out.println();
			}
			// 중간 한줄
//			System.out.println("===============================");
			for(int j=0; j<N; j++) {
//				System.out.print(map[N/2][j]+" ");
				sum+=map[N/2][j];
			}
//			System.out.println();
//			System.out.println("===============================");
			// 아래 삼각형
			for(int i=N/2+1; i<N; i++) {
				for(int j=N/2-(N-1-i); j<N/2+(N-1-i)+1; j++) {
//					System.out.print(map[i][j]+" ");
					sum+=map[i][j];
				}
//				System.out.println();
			}
			
			
//			printMap();
			System.out.println("#"+test_case+" "+sum);
		}
		
	}


	private static void printMap() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
