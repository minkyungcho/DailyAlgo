package baekjoon.simulation;


/**
 * 1. 데이타를 H, W만큼 읽어 배열에 저장   
 * 2. WC3개의 조합을 생성한다.         
 *    2.1 조합이 완성되면 배열값을 새로운 배열에 저장한다. => 모든 조합을 다 수행해서 최대값을 찾아야 하므로 
 *    2.2 적의 높이만큼 적을 제거한다. 
 *      2.2.1 적을 담을 자료 구조 선언 
 *            queue : 궁수 한명이 사거리내에 쏠수 있는 적을 담을 자료 구조
 * 	   deathNote : 사거리가 가장 짧고 같은 사거리면 왼쪽 적을 담아놓을 자료구조
 *      2.2.2 적의 높이만큼 반복
 *        2.2.2.1 궁수 수만큼 반복 
 *          2.2.2.1.1 사거리내에 있는 적을 선별해서 우선 queue에 담는다. 
 * 	 2.2.2.1.2 사거리내에 있는 적들중 사거리가 짧고 왼쪽 적을  deathNote에 담는다. 
 * 	 2.2.2.1.3 queue 클리어
 *        2.2.2.2 deathNote에서 적을 꺼내 제거하고 적을 수를 센다. 
 *        2.2.2.3 deathNote clear
 *        2.2.2.3 맵이동 
 * 	 
 *    2.3 max값 비교해서 최고 값을 갱신
 * 3. 값 출력
 * 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main_Simulation_17135_캐슬디펜스_array  {
	static int H,W,D;
	static int[][] map;
	static int[][] newMap;
	static int[] combi = new int[3];
	static int max;
	/**죽은 적을 표시하기 위한 클래스 */
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int d;
		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		public int compareTo(Pos o) {
			int sd=  d - o.d;
			if(sd==0) {
				return c-o.c;   //거리가 같으면 왼쪽거 정렬
			}else {
				return sd;
			}
		}
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/simulation/17135_캐슬디펜스.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		max = 0;
		map = new int[H][W];
		newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			tokens = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int cnt, int start) {
		if(cnt == 3) {
			//게임 맵 초기화 
			for (int i = 0; i < H; i++) {
				System.arraycopy(map[i], 0, newMap[i], 0, W);
			}
			int count = shoot(newMap);
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i <W; i++) {
			combi[cnt]= i;
			dfs(cnt+1, i+1);
		}
	}
	static int shoot(int[][] newMap) {
		LinkedList<Pos> queue = new LinkedList<>();
		LinkedList<Pos> deathNote = new LinkedList<>();
		
		int cnt=0;
		for (int i = 0; i < H; i++) {			// 맵의 높이 만큼 반복 
			for (int j = 0; j < 3; j++) {		// 궁수의 수만큼 반복
				int idx = combi[j];				// 궁수의 위치 
				int nr;						
				for (int k = 1; k <=D; k++) {	// 성벽에서 사거리까지 
					nr = H-k;
					for (int nc = 0; nc <W; nc++) {// 
						int d = Math.abs(H-nr)+Math.abs(idx-nc);
						// 경계내에 있고 사거리 내에 있는 적이면
						if(nr>-1 && nr<H && nc>-1 && nc<W && d<=D && newMap[nr][nc]>0) {
							queue.add(new Pos(nr, nc, d));		//죽일놈 찜 
						}
					}
				}
				//여기부터 다시 
				if(queue.size()>0) {
					Collections.sort(queue);
					deathNote.add(queue.poll());  //사거리가 제일 짧고, 왼쪽 놈을 deathNote에 추가 
				}
				queue.clear();
			}
			//궁수들이 모두 쐈으니 적을 제거 하기 
			for (Pos pos : deathNote) {
				if( newMap[pos.r][pos.c]>0) {
					newMap[pos.r][pos.c]= 0;		  //적을 제거
					cnt++;
				}
			}
			deathNote.clear();						
			moveMap(newMap);
		}
		return cnt;
	}
	static void moveMap(int[][] newMap) {
		for (int i = H-1; i >0; i--) {
			newMap[i] = newMap[i-1];
		}
		newMap[0] = new int[W];
	}
}




