package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	
	static int N; // 편의점 개수 
	static Location[] location;
	static boolean[] visit;
	static String res;
	static Location festival;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			location = new Location[N+2]; // 집, 편의점(N), 페스티벌 
			visit = new boolean[N+2];

			// 모든  좌표 
			for (int n = 0; n < N+2; n++) {
				st = new StringTokenizer(br.readLine());
				location[n] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			res = "sad";
			
			Location home = location[0];
			festival = location[N+1];
			
			bfs(home);
			
			System.out.println(res);
			
		}
		
	}

	private static void bfs(Location start) {
		Queue<Location> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Location front = q.poll();
			if(front.x == festival.x && front.y == festival.y) {
				res = "happy";
				return;
			}
			
			for (int n = 1; n < N+2; n++) {
				if(!visit[n] && calDistance(location[n], front)) {
					q.add(location[n]);
					visit[n] = true;
				}
			}
		}
	}

	private static boolean calDistance(Location next, Location now) {
		return Math.abs(next.x-now.x)+Math.abs(next.y-now.y) <= 1000;
	}

	static class Location{
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Location [x=" + x + ", y=" + y + "]";
		}
	}
}

