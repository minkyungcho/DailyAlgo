package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기_영역구분 {

	static int N;
	static int whiteNum;
	static int blueNum;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/im/1335_색종이만들기_영역구분.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ready(0, 0, N);

		System.out.println(whiteNum);
		System.out.println(blueNum);
	}


	private static void ready(int r, int c, int n) {
		int first = map[r][c];
		
		// 길이가 1일때는 바로 색 확인하기
		if(n==1) {
			if(first==0) whiteNum++;
			else blueNum++;
			return;
		}
		
		// 하나의 색인지 체크
		boolean check = true;
		go:
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(map[i][j]!=first) {
					check = false;
					break go;
				}
					
			}
		}
		
		// 하나의 색이면 색에 따라 체크
		if(check) {
			if(first==0) whiteNum++;
			else blueNum++;
			return;
		}else {
			//하나의 색이 아니면 4등분
			ready(r, c, n/2);
			ready(r+n/2, c, n/2);
			ready(r, c+n/2, n/2);
			ready(r+n/2, c+n/2, n/2);
		}
		
	}

}
