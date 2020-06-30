package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_T {
	
	static int N, M; // 지도크기 N(2 <= N <= 50), 남길 치킨집 개수 M(1 <= M <= 13)
	// 치킨 집들 & 집들을 따로 관리 --> 맵은 사용하지 않고.
	static List<Point> chickenStores, homes;
	// 도시의 최소 치킨거리 
	static int MinChickenDist = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 집과 치킨집 가져오기 
		chickenStores = new ArrayList<>();
		homes = new ArrayList<>();
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				int info = Integer.parseInt(st.nextToken());
				if(info == 1) { // 집 
					homes.add(new Point(r, c));
				}else if(info == 2) { // 치킨 집 
					chickenStores.add(new Point(r, c));
				}
			}
		}
		
		// 입력 검증
//		System.out.println("치킨집 "+chickenStores);
//		System.out.println("가정집 "+homes);
		
		// 전체 치킨집 chickenStores.size() 에서 M개 고르기 
		comb(M, new Point[M], 0);
		
		System.out.println(MinChickenDist);
	}

	/**
	 * 
	 * @param ti	: 찾을 개수 
	 * @param temp	: 찾은 녀석들 
	 * @param si	: 찾는 시작 위치 
	 */
	static void comb(int ti, Point[] temp, int si) {
		if(ti == 0) {
			//System.out.println(Arrays.toString(temp));
			// 도시의 치킨 거리는?
			check(temp);
			return;
		}else {
			for (int i = si; i < chickenStores.size(); i++) {
				temp[ti-1] = chickenStores.get(i);
				comb(ti-1, temp, i+1);
			}
		}
	}
	
	static class Point{
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		// 치킨 거리 
		public int getDist(Point other) {
			return Math.abs(this.row - other.row) + Math.abs(this.col - other.col); 
		}
			
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
		
	}
	
	static void check(Point[] temp) {
		int cityChickenDist = 0;
		
		// 집 별로 각 치킨집과의 최소 거리를 찾아서 sum 
		for(Point p : homes) {
			int chickenDist = Integer.MAX_VALUE;
			for(Point c : temp) {
				int dist = p.getDist(c);
				chickenDist = Math.min(chickenDist, dist);
			}
			cityChickenDist += chickenDist;
		}
		MinChickenDist = Math.min(MinChickenDist, cityChickenDist);
	}
}
