package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출 {

	static int T;
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] fvisit;
//	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] dir2 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int srS;
	static int scS;
	static int min;
	static int t;
	static String result;
	static LinkedList<int[]> fireQ = new LinkedList<>();
	static LinkedList<int[]> sQ = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/jungol/im/1082_화염에서탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		T = Integer.parseInt(br.readLine());
//		for (int testcase = 1; testcase < T + 1; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			fvisit = new boolean[R][C];
			t = 1;
			result = "impossible";
			min = Integer.MAX_VALUE;
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'S') {
						srS = i;
						scS = j;
						fvisit[i][j] = true;
						sQ.offer(new int[] { i, j, t });
					} else if (map[i][j] == '*') {
						fvisit[i][j] = true;
						fireQ.offer(new int[] { i, j });
					}
				}
			}

			bfs();

			if(min!=Integer.MAX_VALUE) {
				result = (min-1) + "";
			}
			
//			System.out.println("#" + testcase + " " + result);
			System.out.println(result);
//		}

	}

	private static void bfs() {


		int[] cur;
		int[] fcur;
		int nr, nc, r, c;
		int fnr, fnc, fr, fc;
		while (true) {

			if (sQ.isEmpty()) {
				return;
			}
//			print();
			
			// fire
			if (!fireQ.isEmpty()) {
				int qsize = fireQ.size();
				for (int n = 0; n < qsize; n++) {
					fcur = fireQ.poll();
					fr = fcur[0];
					fc = fcur[1];

					for (int d = 0; d < 4; d++) {
						fnr = fr + dir2[d][0];
						fnc = fc + dir2[d][1];

						if (fnr > -1 && fnr < R && fnc > -1 && fnc < C && map[fnr][fnc] == '.' && !fvisit[fnr][fnc]) {
							map[fnr][fnc] = '*';
							fvisit[fnr][fnc] = true;
							fireQ.offer(new int[] { fnr, fnc });
						}
					}

				}
			}
//			print();
			// S move
			if(!sQ.isEmpty()) {
				int ssize = sQ.size();
				for (int n = 0; n < ssize; n++) {
					cur = sQ.poll();
					r = cur[0];
					c = cur[1];
					t = cur[2];
					t++;
					for (int d = 0; d < 4; d++) {
						nr = r + dir2[d][0];
						nc = c + dir2[d][1];
						if (nr > -1 && nr < R && nc > -1 && nc < C) {
							if (map[nr][nc] == '.' && !fvisit[nr][nc]) {
								fvisit[nr][nc] = true;
								sQ.offer(new int[] { nr, nc, t });
							} else if (map[nr][nc] == 'D') {
								min = t;
								return;
							}
						}
					}
					
				}
				
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
