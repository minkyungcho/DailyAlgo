package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_d4_1258_행렬찾기 {
	
	static class Rect implements Comparable<Rect>{
		int r;
		int c;
		int rc;
		
		public Rect() {
			
		}
		
		public Rect(int r, int c, int rc) {
			this.r = r;
			this.c = c;
			this.rc = rc;
		}

		@Override
		public int compareTo(Rect o) {
			
			// 사각형의 크기로 정렬
			int rr = rc - o.rc;
			if(rr==0) {
				// 사각형의 크기가 같은 경우 행의 크기로 정렬
				rr = r - o.r;
			}
			return rr;
		}
	}
	
	static int T;
	static int N;
	static int[][] map;
	
	// right down left up 
	// 우하좌상 
	static int[] dirR = {0, 1, 0, -1};
	static int[] dirC = {1, 0, -1, 0};
	static int width;
	static int height;
	static int matrixNum;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/1258_행렬찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T + 1; testcase++) {
			ArrayList<Rect> rectList = new ArrayList<>();
			matrixNum = 0;
			width=0;
			height=0;
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			StringTokenizer st;
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int n = map[i][j];
					if(n!=0) {
						goRight(i, j, 1);
						goDown(i, j, 1);
						for (int k = i; k < i+height; k++) {
							for (int k2 = j; k2 < j+width; k2++) {
								map[k][k2]=0;
							}
						}
						matrixNum++;
						rectList.add(new Rect(height, width, height*width));
//						System.out.println("width:"+width+" height:"+height);
					}
					width=0;
					height=0;
				}
			}
			
			// submatrix 정렬
			Collections.sort(rectList);
			
			// 출력 
			System.out.print("#"+testcase+" ");
			System.out.print(matrixNum+" ");
			for(Rect r : rectList) {
				System.out.print(r.r+" "+r.c+" ");
			}
			System.out.println();
		}
	}

	private static void goDown(int r, int c, int cnt) {
		map[r][c] = 0;
		
		int nr = r+1;
		int nc = c;
		if(map[nr][nc]!=0) {
			goDown(nr, nc, cnt+1);
		}else {
			height = cnt;
		}
	}

	private static void goRight(int r, int c, int cnt) {
		map[r][c] = 0;
		int nr = r;
		int nc = c+1;
		if(map[nr][nc]!=0) {
			goRight(nr, nc, cnt+1);
		}else {
			width = cnt;
		}
	}

	private static void print() {
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
