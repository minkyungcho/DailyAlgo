package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2567_색종이2_2 {
	
	static int N;
	static int R;
	static int C;
	static int[][] map;
	static int result=0;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/2567_색종이3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[101][101];
		
		int[] dirR = {1, -1, 0, 0};
		int[] dirC = {0, 0, 1, -1};
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int r=R; r<R+10; r++) {
				for(int c=C; c<C+10; c++) {
					map[r][c]=1;
				}
			}
		}
//		print();
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]==1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dirR[d];
						int nc = j + dirC[d];
						
						if(nr>-1 && nr<=100 && nc>-1 && nc<=100 && map[nr][nc]==0) {
							result++;
						}
					}
					
				}
				
			}
		}
		
		System.out.println(result);
	}

	private static void print() {
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
