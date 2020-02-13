package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2567_색종이2 {
	
	static int N;
	static int R;
	static int C;
	static int[][] map;
	static int result;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/boj/2567_색종이2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[101][101];
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int r=R; r<R+11; r++) {
				for(int c=C; c<C+11; c++) {
					map[r][c]++;
				}
			}
			System.out.println(result);
			result += 40-2*check(R, C);
//			if(i!=0) {
//				result += 40-check(R, C);
//			}
		}
		print();
		System.out.println(result);
	}

	private static int check(int R, int C) {
		int lr = 0;
		int lc = 0;
		int fr = 0;
		int fc = 0;
		int cnt = 1;
		for(int r=R; r<R+11; r++) {
			for(int c=C; c<C+11; c++) {
				if(map[r][c]!=1 && map[r][c]!=0) {
					System.out.print("("+r+","+c+") ");
					if(cnt==1) {
						fr = r;
						fc = c;
					}
					cnt++;
					lr = r;
					lc = c;
				}
			}
			System.out.println(fr+" "+lr);
			System.out.println(fc+" "+lc);
			System.out.println();
		}
		int subr = Math.abs(fr-lr);
		int subc = Math.abs(fc-lc);
//		if(subr==0) {
//			subr=1;
//		}
//		if(subc==0) {
//			subc=1;
//		}
//		System.out.println("겹치는 둘레"+2*(Math.abs(rr)+Math.abs(cc)));
		return subr+subc;
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
