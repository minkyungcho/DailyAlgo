package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	
	static int R, C;
	// 사방 탐색
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map, graph;
	static int islandIdx; // 섬의 번호 - 2 <= 섬의 개수 <= 6
	static int INF = 987654321; // 그래프에서 사용할 초기화 값
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("res.b"))
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R= Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// map 확인 
//		print();
		
		// 섬 구별하기 
		islandIdx = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 땅을 발견하면 거기를 기점으로 BFS 탐색 --> 연결된 지점들을 표시 
				if(map[r][c] == 1) {
					bfs(r, c); // 한번의 BFS --> 섬 하나가 발견되었다!!
					islandIdx++;
				}
			}
		}
		
		// map 확인 
//		print();
		
		// 그래프 초기화 하기..
		graph = new int[islandIdx][islandIdx];
		// 각 섬간의 최단 거리로 그래프를 구성할 계획 - 그래프의 값을 최대값으로 초기화 
		for (int r = 2; r < islandIdx; r++) {
			Arrays.fill(graph[r], INF);
		}
		
		// 각 섬별로 거리(간선 가중치) 찾아보기 
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]>1) { // 섬의 땅 
					makeGraph(r, c);
				}
			}
		}
		
	}

	static void makeGraph(int row, int col) {
		// 내 땅 
		int base = map[row][col];
		for (int d = 0; d < dir.length; d++) {
			
			for (int l = 1; ; l++) {
				int nr = row + dir[d][0] * l;
				int nc = col + dir[d][1] * l;
				if(isIn(nr, nc)) {
					// 바다면 쭉 간다.
					if(map[nr][nc] == 0) {
						continue;
					}
					else if(map[nr][nc]==base) {
					// 내륙 -> 그만..
						break;
					}
					// 아니면 다른 섬 --> 거리를 2칸 이상 떨어져야 한다.
					else {
						// 드디어 다리를 만둘 수 있음
						
					}
				}
				// 역사 안에 없었으면  그만..
				else {
					
					if(l>2){
						// 무향 그래프 --> 양방향 업데이트 
					}
					break;
				}
			}
		}
		
		
	}

	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		// 방문 표시 - map 자체에다가 islandIdx로 표시 한다.
		map[row][col] = islandIdx;
		while(!q.isEmpty()) {
			Point front = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int nr = front.row + dir[d][0];
				int nc = front.col + dir[d][1];
				// map[nr][nc]==1 --> 아직 방문하지 않은 땅이라면...
				if(isIn(nr, nc) && map[nr][nc]==1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
	}
	
	static boolean isIn(int row, int col) {
		return 0<=row&&row<R && 0<=col&&col<C;
	}
	
	static class Point{
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
