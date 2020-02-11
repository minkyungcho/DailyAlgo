package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	
	// queue에 넣을 객체의 좌표 값과, 벽돌이 깨질 때 범위 
	static class Brick{
		int h, w, range;
		
		public Brick(){
			
		}
		public Brick(int h, int w, int range){
			this.h = h;
			this.w = w;
			this.range = range;
		}
	}
	
	static Queue<Brick> q;
	
	static int T;
	static int N;
	static int H;
	static int W;
	static int[][] map;
	static int[] sets;
	static boolean[][] visited;
	static int ans;
	
	// up down left right
	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/5656_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testcase = 1; testcase < T + 1; testcase++) {

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 구슬 
			W = Integer.parseInt(st.nextToken());	// 열  
			H = Integer.parseInt(st.nextToken());	// 행 
			
			q = new LinkedList<>();
			sets = new int[N];
			map = new int[H][W];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			makeSet(0);
			
			
//			print();
			System.out.println("#" + testcase + " "+ans);
			
//			return;
		}
	}
	
	// sets를 지정해주는 함수 
	private static void makeSet(int set) {
		if(set==N) {
			// 벽돌 선별 및 부수기 
			int[][] copy = mapCopy();
			int brick;
			for (int i = 0; i < N; i++) {
				visited = new boolean[H][W];
				selectAndCrush(copy, sets[i]);
				blockDown(copy);
			}
			
			brick = count(copy);
			
			// 현재 남은 벽돌 수와 지금까지 가장 적게 남은 벽돌 수를 비교해 ans 갱신  
			ans = (ans > brick) ? brick : ans;
			return;
		}
		
		for (int w = 0; w < W; w++) {
			sets[set] = w;
			makeSet(set+1);
		}
		
	}

	// 남은 벽돌 개수 세어보는 함수  
	private static int count(int[][] copy) {
		int brick = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if(copy[h][w]>0) brick++;
			}
		}
		return brick;
	}

	private static void blockDown(int[][] copy) {
		Queue<Integer> temp;
		for (int w = 0; w < W; w++) {
			temp = new LinkedList<>();
			for (int h = H-1; h > -1; h--) {
				if(copy[h][w]>0) temp.offer(copy[h][w]);
			}
			for (int h = H-1; h > -1; h--) {
				if(!temp.isEmpty()) {
					copy[h][w] = temp.poll();
				}else {
					copy[h][w] = 0;
				}
			}
		}
	}

	private static void selectAndCrush(int[][] copy, int set) {
		// set에서 떨어진 구슬이 가장 처음 만나는 벽돌을 찾는 부분 
		for (int h = 0; h < H; h++) {
			if(copy[h][set]>0) {
				q.offer(new Brick(h, set, copy[h][set]));
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Brick now = q.poll();
			int nh, nw;
			
			for (int d = 0; d < 4; d++) {
				for (int r = 0; r < now.range; r++) {
					nh = now.h + dirR[d]*r;
					nw = now.w + dirC[d]*r;
					
					if(nh>-1 && nh<H && nw>-1 && nw<W && !visited[nh][nw]) {
						visited[nh][nw] = true;
						q.offer(new Brick(nh, nw, copy[nh][nw]));
						copy[nh][nw] = 0;
					}
				}
			}
		}
	}

	private static int[][] mapCopy() {
		int[][] arr = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
