package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1861_정사각형방 {

	static int T;
	static int N;
	static int[][] room;
	static int[][] roomCnt;
	static int roomNum;
	static int roomCntMax;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// up down left right
		int[] dirR = {-1, 1, 0, 0};
		int[] dirC = {0, 0, -1, 1};
		
		int dn = 4;
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T + 1; testcase++) {
//			roomNum = 1;
			roomCntMax = 0;
			
			N = Integer.parseInt(br.readLine());
			room = new int[N+1][N+1];
			roomCnt = new int[N+1][N+1];
			
			// 방 번호 입력하기
			for (int i = 1; i < N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < N+1; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("======처음map======");
			print();
			
//			for(int )
			
			
			
			
			
			// 출력
			System.out.println("#"+testcase+" "+roomNum+" "+roomCntMax);
			return;
		}
	}
	private static void print() {

		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(room[i][j] + " ");
			}
			System.out.println();
		}

	}
}
