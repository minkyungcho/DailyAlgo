package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2571_색종이3 {
	static class Paper{
		int r;
		int c;
		int rc;
		
		public Paper() {
		}
		public Paper(int r, int c, int rc) {
			this.r = r;
			this.c = c;
			this.rc = rc;
		}
		@Override
		public String toString() {
			return "Paper [r=" + r + ", c=" + c + ", rc=" + rc + "]";
		}
	}
	static int N;
	static int R;
	static int lR;
	static int C;
	static int lC;
	static int H;
	static int W;
	static int[][] map;
	static int result=0;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/2571_색종이3.txt"));
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
		ArrayList<Paper> paperList = new ArrayList<>();
		int max = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(map[i][j]==1) {
					System.out.println("START : "+i+" "+j);
					goRight(i, j, 1);
					goDown(i, j, 1);
//					System.out.println("r d END:"+i+" "+j);
//					System.out.println(lR+" "+lC);
					System.out.println(H+" "+W);
					
					if(checkFill(i, j, H, W)) {
						if(max<H*W) {
							max = H*W;
						}
						
					}
//					if(max<(lR-i)*(lC-j)) {
////						max = lR*lC;
//						max = (lR-i)*(lC-j);
//					}
					Paper p = new Paper(lR, lC, lR*lC);
					paperList.add(p);
				}
			}
		}
		System.out.println(max);
		
	}
	private static boolean checkFill(int r, int c, int h, int w) {
		for (int i = r; i < r+h+1; i++) {
			for (int j = c; j < c+w+1; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
		
	}
	private static void goDown(int r, int c, int cnt) {
		
		int nr = r+1;
		int nc = c;
		if(map[nr][nc]==1) {
			goDown(nr, nc, cnt+1);
		}
		else {
			H = cnt;
//			lR = r;
//			System.out.println("down END:"+r+" "+c);
		}
		
		
	}
	private static void goRight(int r, int c, int cnt) {
		
		int nr = r;
		int nc = c+1;
		if(map[nr][nc]==1) {
			goRight(nr, nc, cnt+1);
		}
		else {
			W = cnt;
//			lC = c;
//			System.out.println("right END:"+r+" "+c);
		}
		
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
