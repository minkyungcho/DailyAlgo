package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 초기 좌표에서 이동
 * 경계를 벗어난 경우  out문자 출력 
 * 입력 :
 *  다음줄 부터 :  배열의 개수   초기row좌표, 초기col좌표, 이동 개수 , {이동 방향, 스텝} *n 
 *  1 : 오른쪽 
 *  2 : 아래쪽
 *  3 : 왼쪽
 *  4 : 윗쪽
 *  
 *  8  3 3 3 1 1 2 2 1 1	
 *  8  3 1 3 4 2 1 1 4 1	
 */
public class FillCell09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("8  3 3 4 1 1 2 2 1 1 1 3");
//		Scanner sc = new Scanner("8  3 3 3 1 1 2 2 1 1");
//		Scanner sc = new Scanner("8  3 1 3 4 2 1 1 4 1");
//		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		// 우 하 좌 상  
		int[] dirR = {0, 1, 0, -1};
		int[] dirC = {1, 0, -1, 0};
		int dn = dirR.length;
		
		// 초기 좌표 설정  
		int r = sc.nextInt();
		int c = sc.nextInt();
		map[r][c] = 1;
		
		// 이동개수  
		int num = sc.nextInt();
		
		// {이동방향, 스텝}
		for(int n=0; n<num; n++) {
			int dir = sc.nextInt();
			int step = sc.nextInt();
			
			int nr = r + dirR[dir-1]*step;
			int nc = c + dirC[dir-1]*step;
			
			if(nr>-1 && nr<N && nc>-1 && nc<N) {
				map[nr][nc] = 1;
				map[r][c] = 0;
				r = nr;
				c = nc;
			}else {
				System.out.println("out");
				return;
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
