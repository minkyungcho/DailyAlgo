package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1798_범준이의제주도여행계획 {
	static StringBuilder output = new StringBuilder();
	static int N, M; // (3≤ N ≤35) (1≤ M ≤5)
	
	// 각 정점을 연결할 그래프 
	static int[][] graph;
	
	// 관리할 지점들
    static Point airPort;
    static List<Point> hotels;
    static List<Point> points;
	
    // 최대 만족도 
    static int maxSatis;
    static List<Integer> maxSatisPath;
    
    // 탐색에 사용할 임시 경로 
    static Stack<Integer> tempPath;
    
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d5/1798_범준이의제주도여행계획.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
	
			// 1. 그래프 구성 
			graph = new int[N+1][N+1];
			//
			for (int r = 1; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = r+1; c < graph.length; c++) {
					graph[c][r] = graph[r][c] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			// 2. 지점 정보 가져오기 
			points = new ArrayList<>();
			hotels = new ArrayList<>();
			
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine().trim());
				String type = st.nextToken();
				if(type.contentEquals("H")) {
					hotels.add(new Point(type, n));
				}else if(type.contentEquals("A")) {
					airPort = new Point(type, n);
				}else {
					int playTime = Integer.parseInt(st.nextToken());
					int satis = Integer.parseInt(st.nextToken());
					points.add(new Point(type, n, playTime, satis));
				}
			}
			
			// 3. 관광지에 가장 가까운 호텔 정보 설정해주기. - graph 
			for(Point p : points) {
				int min = Integer.MAX_VALUE;
				for(Point h : hotels) {
					if(graph[p.idx][h.idx] < min) {
						min = graph[p.idx][h.idx];
						p.nearH = h;
					}
				}
			}
			
			// 4. 여행 준비 
			maxSatis = Integer.MIN_VALUE;
			tempPath = new Stack<>();
			
			// solve();
			solve(0, airPort, 0, 0, new boolean[N+1]);
			
			// 5. 결과 출력 
			output.append("#").append(tc).append(" ");
			if(maxSatis == Integer.MIN_VALUE) {
				output.append(0);
			}else {
				output.append(maxSatis).append(" ");
				for(int i : maxSatisPath) {
					output.append(i).append(" ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	static void solve(int day, Point start, int satis, int time, boolean[] visit) {
		// 기저조건 
		if(day == M) {
			if(satis > maxSatis) {
				maxSatis = satis;
				// 최대 만족도에서의 경로 전달 
				maxSatisPath = new ArrayList<>(tempPath);
			}
			return;
		}
		
		// 일반 탐색 
		boolean canGoNext = false; // 다음지점으로 갈 수 있니? 
		for(Point point : points) {
			// 갈 수 있는 지점들을 찾아서 계속 돌아다닌다.
			if(!visit[point.idx]) {
				// 미방문이라면.. 그 지점을 갈 수 있는지 시간을 계산해볼 필요가 있다.
				int tempTime = time + graph[start.idx][point.idx] + point.playTime;
				if(day == M-1) { // 마지막날 
					tempTime += graph[point.idx][airPort.idx];
				}else {
					tempTime += graph[point.idx][point.nearH.idx];
				}
				if(tempTime > 540) {
					continue;
				}
				canGoNext = true;
				visit[point.idx] = true;
				tempPath.push(point.idx);
				solve(day, point, satis + point.satis, time + graph[start.idx][point.idx] + point.playTime, visit);
				tempPath.pop();
				visit[point.idx] = false;
			}
		}
		// 관광지로 못가면 날짜에 따라서 공항/호텔로 이동
		if(!canGoNext) {
			if(day == M-1) { // 마지막날 공항으로 가야함 
				tempPath.push(airPort.idx);
				solve(day+1, airPort, satis, 0, visit);
				tempPath.pop();
			}else { // 호텔로 가야함 
				for(Point hotel : hotels) {
					if(time + graph[start.idx][hotel.idx] <= 540) {
						tempPath.push(hotel.idx);
						solve(day+1, hotel, satis, 0, visit);
						tempPath.pop();
					}
				}
			}
		}
	}
	
	static class Point{
		String type; // A, H, P
		int idx;
		int playTime;
		int satis;
		Point nearH;
		
		public Point(String type, int idx) {
			this(type, idx, 0, 0);
		}
		public Point(String type, int idx, int playTime, int satis) {
			super();
			this.type = type;
			this.idx = idx;
			this.playTime = playTime;
			this.satis = satis;
		}
		@Override
		public String toString() {
			return "Point [type=" + type + ", idx=" + idx + ", playTime=" + playTime + ", satis=" + satis + "]";
		}
	}
	
}
