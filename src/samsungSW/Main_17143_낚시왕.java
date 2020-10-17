package samsungSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1. 낚시왕 한칸 이동 
 * 2. 가까운 상어 잡기 
 * 		- 낚시왕 현재 열 위치에서 행 우선 탐색하면서 상어 찾기
 * 		- 상어 찾았으면 => 그 자리 상어 없애기   
 * 3. 나머지 상어 무빙 
 * 		- 상어 자신 속도만큼 이동
 * 			=> 
 * 4. 이동한 상어 정리(먹기)
 * 		- 한 칸에 여러 상어들 있을 수 있다. => ArrayList[][] map : 여러 상어 보관하는 map => 상어 도착할때마다 크기 큰 상어로 바꿔줌 
 * 		- 크기가 제일 큰 상어가 다른 상어 잡아먹는다. -> 크기가 젤 큰 상어만 original map에 저장 
 */

public class Main_17143_낚시왕 {
	
	static class Shark{
		int speed, dir, size;

		public Shark(int speed, int dir, int size) {
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
		
	}
	
	static int R, C, M, sum, col;
	static Shark[][] map;
	static final int UP=1, DOWN=2, RIGHT=3, LEFT=4;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = col = 0; // col : 낚시왕 위치열 
		map = new Shark[R][C];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		while(col<C) {
			
			// 가까운 상어 잡기
			take();
			
			// 상어 이동하며 잡아먹기 
			move();
			col++;
		}
		System.out.println(sum);
	}


	private static void move() {
		
		Shark[][] temp = new Shark[R][C];
		
		int k=0, s=0, a=0, x, y, d;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Shark curShark = map[i][j];
				if(curShark == null) continue; // 상어가 없으면 다음 칸으로 넘어가 
				if(curShark.dir == UP || curShark.dir == DOWN) { // 위아래로 움직이기때문에 행이 계속 변함 
					k = i;
					s = curShark.speed%(2*(R-1)); // 최적화 속도 : 2*(R-1)번 이동하면 제자리 
					a = (curShark.dir==UP) ? -1 : 1; // 행첨자 증감을 위한 변수 
					while(s-- > 0) {
						if(k+a<0 || k+a>=R) a = -a; // 경계를 벗어나면 방향 턴 
						k += a;
					}
					x = k;
					y = j;
					d = a<0 ? UP : DOWN;
				}else { // 왼쪽 오른쪽 움직임. => 열변화
					k = j;
					s = curShark.speed%(2*(C-1)); // 최적화 속도 : 2*(C-1)번 이동하면 제자리 
					a = (curShark.dir==LEFT) ? -1 : 1; // 열첨자 증감을 위한 변수  
					while(s-- > 0) {
						if(k+a<0 || k+a>=C) a = -a; // 경계를 벗어나면 방향 턴 
						k += a;
					}
					x = i;
					y = k;
					d = a<0 ? LEFT : RIGHT;
				}
				
				curShark.dir = d;
				// s만큼 이동한 후의 x, y 위치에 다른 상어 있는 지 체크하여 다른 상어가 있다면 크기 비교하여 큰 상어로 남김.
				if(temp[x][y] != null) { // 다른 상어가 있다. => 크기 비교!!
					if(temp[x][y].size < curShark.size) {
						temp[x][y] = curShark;
					}
					
				}else { // 다른 상어가 없으면 자기가 그 자리에 남기 
					temp[x][y] = curShark;
				}
			}
		} // end for i
		
		// 자리 이동과 잡아먹기 끝난 형태를 map에 다시 저장해주기 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
		
		
	}


	private static void take() { // 낚시왕의 현위치(땅 기반) 에서 가장 가까운 상어 잡기 
		for (int i = 0; i < R; i++) {
			if(map[i][col] != null) { // 해당 행에 상어가 있으면 
				sum += map[i][col].size; // 상어의 size만큼 sum에 누적 
				map[i][col] = null; // 상어 잡고 null 로 바꿔주기 
				break;
			}
		}
	}

}

