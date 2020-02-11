package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1873_상호의배틀필드 {

	static int T;
	static int N;
	static int H;
	static int W;
	static char[][] map;
	static char[] cmd;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d3/1873_상호의배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dirR = { -1, 1, 0, 0 };
		int[] dirC = { 0, 0, -1, 1 };
		int dn = 4;

		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T + 1; testcase++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = "";
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			int carR=0;
			int carC=0;
			int dr=0;
			int dc=0;
			for (int i = 0; i < H; i++) {
				str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						carR = i;
						carC = j;
						// 전차 모양에 따른 방향 설정
						if (map[i][j] == '^') {
							dr = dirR[0];
							dc = dirC[0];
						} else if (map[i][j] == 'v') {
							dr = dirR[1];
							dc = dirC[1];
						} else if (map[i][j] == '<') {
							dr = dirR[2];
							dc = dirC[2];
						} else if(map[i][j] == '>'){
							dr = dirR[3];
							dc = dirC[3];
						}
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			cmd = new char[N];
			String cmdStr = br.readLine();
			for (int j = 0; j < N; j++) {
				cmd[j] = cmdStr.charAt(j);
			}

//			System.out.println("전차위치 : "+carR+" "+carC);
//			System.out.println("전차방향 : "+dr+" "+dc);
			// cmd 받기
			for (int n = 0; n < N; n++) {
//				System.out.println("==========" + cmd[n] + "===========");
				int nr;
				int nc;
				
				cmdout:
				switch (cmd[n]) {
				case 'U':
//					System.out.println("UP");
					dr = dirR[0];
					dc = dirC[0];
					nr = carR + dr;
					nc = carC + dc;
					map[carR][carC] = '^';
					if (nr > -1 && nr < H && nc > -1 && nc < W) {
						if(map[nr][nc]=='.') {
							map[carR][carC] = '.';
							map[nr][nc] = '^';
							carR = nr;
							carC = nc;
						}
					}
					break;
				case 'D':
//					System.out.println("DOWN");
					dr = dirR[1];
					dc = dirC[1];
					nr = carR + dr;
					nc = carC + dc;
					map[carR][carC] = 'v';
					if (nr > -1 && nr < H && nc > -1 && nc < W) {
						if(map[nr][nc]=='.') {
							map[carR][carC] = '.';
							map[nr][nc] = 'v';
							carR = nr;
							carC = nc;
						}
					}
					break;
				case 'L':
//					System.out.println("LEFT");
					dr = dirR[2];
					dc = dirC[2];
					nr = carR + dr;
					nc = carC + dc;
					map[carR][carC] = '<';
					if (nr > -1 && nr < H && nc > -1 && nc < W) {
						if(map[nr][nc]=='.') {
							map[carR][carC] = '.';
							map[nr][nc] = '<';
							carR = nr;
							carC = nc;
						}
					}
					break;
				case 'R':
//					System.out.println("RIGHT");
					dr = dirR[3];
					dc = dirC[3];
					nr = carR + dr;
					nc = carC + dc;
					map[carR][carC] = '>';
					if (nr > -1 && nr < H && nc > -1 && nc < W) {
						if(map[nr][nc]=='.') {
							map[carR][carC] = '.';
							map[nr][nc] = '>';
							carR = nr;
							carC = nc;
						}
					}
					break;
				case 'S':
//					System.out.println("SHOOTING");
					for (int k = 0; k < 20; k++) {
						nr = carR + dr * k;
						nc = carC + dc * k;
//						System.out.println();
						if (nr > -1 && nr < H && nc > -1 && nc < W) {
							if (map[nr][nc] == '*') {
								map[nr][nc] = '.';
//								carR = nr;
//								carC = nc;
//								System.out.println("벽만났어 : "+nr+" "+nc);
								break cmdout;
							} else if (map[nr][nc] == '#') {
//								carR = nr;
//								carC = nc;
//								System.out.println("강철벽만났어 : "+nr+" "+nc);
								break cmdout;
							}
						}
					}

					break;
				default:
					break;
				}
//				print();
			}

//			print();
			System.out.print("#" + testcase + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void print() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
