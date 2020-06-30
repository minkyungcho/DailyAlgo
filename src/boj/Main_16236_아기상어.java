package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	
	static int N; // 공간의 크기 N(2 <= N <= 20)
	static int[][] map;
	
	static int sharkMoveCnt; // 상어의 이동 거리 
	
	static int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Shark babyShark = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = map[i][j] = Integer.parseInt(st.nextToken());
				if(input==9) {
					babyShark = new Shark(i, j, 2, 0, 0);
					map[i][j] = 0; // 상어 가져오고 0으로 바꿔줌
				}
			}
		}
		
		bfs(babyShark);
		
		System.out.println(sharkMoveCnt);
		
	}
	
	static void bfs(Shark shark) {
		Queue<Shark> q = new LinkedList<>();
		q.offer(shark);
		
		boolean[][] visit = new boolean[N][N];
		visit[shark.row][shark.col] = true;
		
		// 먹을 수 있는 물고기를 저장한 PQ
		PriorityQueue<Fish> targetFishes = new PriorityQueue<>();
		Shark front = null;
		findFish : while(!q.isEmpty()) {
			front = q.poll();
		
			for (int d = 0; d < 4; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				
				if(isIn(nr,nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					// 이동한 점의 값에 따라서 분기 처리.
					if(map[nr][nc]==0 || map[nr][nc]==front.size) { // 이동 가능 
						q.offer(new Shark(nr, nc, front.size, front.depth+1, front.eatCnt));
					} else if(map[nr][nc]<front.size) { // 물고기보다 상어의 크기가 더 크다. 먹을 수 있다. 
						if(targetFishes.isEmpty()) { // 비어 있다. 
							targetFishes.offer(new Fish(nr, nc, map[nr][nc], front.depth+1));
						}else { // 비어있지 않다. pq에 담을 수 있는지 없는지 본다. 
							Fish first = targetFishes.peek();
							if(first.dist < front.depth+1) { // 멀리 있는 경우. 
								break findFish; // 다 찾았다. 
							}else {
								targetFishes.offer(new Fish(nr, nc, map[nr][nc], front.depth+1));
							}
						}
						
					}
				}
			}
		}
		if(targetFishes.isEmpty()) { // 먹을 게 없다.
			return;
		}else { // 먹을 물고기가 있다. 맨 처음 물고기를 먹자.
			Fish food = targetFishes.poll();
			front.eat(); // 먹어라. 
			map[food.row][food.col] = 0; // 먹었으면 초기화.
			
			sharkMoveCnt += food.dist;
			
			bfs(new Shark(food.row, food.col, front.size, 0, front.eatCnt));
		}
	}
	
	static boolean isIn(int row, int col) {
		return 0<=row&&row<N && 0<=col&&col<N;
	}
	
	
	static class Fish implements Comparable<Fish>{
		int row, col;
		int size;
		int dist;
		public Fish(int row, int col, int size, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Fish [row=" + row + ", col=" + col + ", size=" + size + ", dist=" + dist + "]";
		}
		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.row == o.row) {
					return Integer.compare(this.col, o.col);
				}else {
					return Integer.compare(this.row, o.row);
				}
			}else {
				return Integer.compare(this.dist, o.dist);
			}
		}
		
	}
	
	static class Shark{
		int row, col, size, depth, eatCnt;

		public Shark(int row, int col, int size, int depth, int eatCnt) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.depth = depth;
			this.eatCnt = eatCnt;
		}

		@Override
		public String toString() {
			return "Shark [row=" + row + ", col=" + col + ", size=" + size + ", depth=" + depth + ", eatCnt=" + eatCnt
					+ "]";
		}
		
		public void eat(){
			eatCnt++;
			if(eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}

	}

}
