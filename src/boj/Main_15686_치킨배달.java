package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N, M;
	static ArrayList<Point> homes;
	static ArrayList<Point> chickens;
	static Stack<Point> selectChickens; 
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		selectChickens = new Stack<>();
		int input;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N ; j++) {
				input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					homes.add(new Point(i, j));
				}else if(input == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		ans = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(ans);
		
	}

	private static void combination(int start, int cnt) {
		// 조합 완성 
		if(M == cnt) {
			int sum = 0; // 도시의 치킨거리 
			for (Point home : homes) {
				int min = Integer.MAX_VALUE;
				for (Point chicken : selectChickens) {
					int len = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
					min = Math.min(min, len);
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			selectChickens.push(chickens.get(i));
			combination(i+1, cnt+1);
			selectChickens.pop();
		}
	}

}

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}