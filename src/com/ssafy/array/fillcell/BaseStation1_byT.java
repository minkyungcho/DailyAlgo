package com.ssafy.array.fillcell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1_byT {
    static int AnswerN=0;
    
    public static void printMap(String[][] map, int N) {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
    }
    
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		/**
		 * 배열은 한번만 만들어두는 것이 좋다
		 */
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int dn = dir.length;
		
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN=0;
			/**
			 *  1. 데이터 입력받기
			 */
			int N=sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			/**
			 * 2. 전체 배열을 순회하면서 A를 찾기
			 * 	2-1 사방탐색, 사방이 경계안에 있고 H이면
			 * 	2-2 H가 커버된 표시(A, H가 아닌 문자로 변경) 
			 */
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='A') {
						for(int k=0; k<dn; k++) {
							int nr = i+dir[k][0];
							int nc = i+dir[k][1];
							
							if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc]=='H') {
								map[nr][nc] = 'X';
							}
						}
					}
				}
			}
			
			/**
			 * 3. 전체 배열을 순회하면서 H 개수 세기
			 */
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='H') AnswerN++;
				}
			}
			
			
//			printMap(map, N);
			
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
}//end class









