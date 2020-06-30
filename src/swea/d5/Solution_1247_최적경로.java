package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {

	static int N;
	static Point start; 
	static Point end; 
	
	static Point[] route;
	static boolean[] isSelected;
	static int ans;
	static List<Point> list;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d5/1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list = new ArrayList<>();
			Point temp = null;
			for (int i = 0; i < N; i++) {
				temp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				list.add(temp);
			}
			ans = Integer.MAX_VALUE;
			
			// 순열 
			isSelected = new boolean[N];
			route = new Point[N];
			permutation(0);
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	static void permutation(int cnt) {
		if(cnt == N) {
			int sum = 0;
			sum += getDist(route[0], start);
			for(int p = 1; p<N; p++) {
				sum += getDist(route[p], route[p-1]);
			}
			sum += getDist(route[N-1], end);
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			route[cnt] = list.get(i);
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

	static int getDist(Point p1, Point p2) {
		
		return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
	}

	static class Point{
		int row;
		int col;
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
}
