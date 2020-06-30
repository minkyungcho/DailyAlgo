package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d9_5653_줄기세포배양2 {

	static class Cell implements Comparable<Cell>{
		int i; // 세로 좌표 
		int j; // 가로 좌표 
		int x; // 줄기세포 생명력 (처음입력값 보관용)
		
		int t; // 활성화시간 
		
		Cell(int i, int j, int x, int t) {
			this.i = i;
			this.j = j;
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Cell o) {
			if(t!=o.t) return Integer.compare(t, o.t); // 오름차순 정렬
			return -Integer.compare(x, o.x);  
		}
	}
	
	static int[] di = {1, 1, 0, 0}; // 상 하 좌 우 
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d9/5653_줄기세포배양.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		boolean[][] v = new boolean[700][700];
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			// 초기화 
			pq.clear();
			for (int i = 0; i < v.length; i++) { // 줄기세포생명력 1<=X<=10 ,리스트 작업시 0~9로 변경 
				Arrays.fill(v[i], false);
			}
			// 입력 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int i = 350; i < N+350; i++) { // 배열의 중간을 계산 (350,350)
				st = new StringTokenizer(br.readLine());
				// 
				for (int j = 350; j < M+350; j++) {
					int X = Integer.parseInt(st.nextToken());
					if(X!=0) {
						v[i][j] = true;
						pq.offer(new Cell(i,j,X,X+1));
						if(X*2>K) cnt++;
					}
				}
			}
			// 처리 
			int time = 0;
			while(time<=K) {
				Cell c = pq.poll();
				time = c.t;
				if(time>K) break;
				for (int d = 0; d < 4; d++) {
					int ni = c.i + di[d];
					int nj = c.j + dj[d];
					if(!v[ni][nj]) {
						v[ni][nj] = true;
						pq.offer(new Cell(ni,nj,c.x, time+c.x+1));
						if(time+c.x*2 > K) cnt++;
					}
				}
			}
			//
			sb.append("#"+tc+" "+cnt+"\n");
		}
		
		
	}

}
