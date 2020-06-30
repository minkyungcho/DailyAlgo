package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d9_5653_줄기세포배양 {

	static class Cell{
		int i; // 세로 좌표 
		int j; // 가로 좌표 
		int x; // 줄기세포 생명력 (처음입력값 보관용)
		
		int life; // 활성화까지시간 -> 살아있는시간(시간이 지나면서 감소됨)
		int time; // 배양시간 (시간이 지나면서 감소됨)
		int flag; // 활성화상태 (0:비활성화, 1:활성화)
		
		Cell(int i, int j, int x, int life, int time, int flag) {
			this.i = i;
			this.j = j;
			this.x = x;
			this.life = life;
			this.time = time;
			this.flag = flag;
		}
	}
	
	static int N, M, K;
	static int[][] map;
	static List<ArrayList<Cell>> list; // 줄기세포 생명력 (1<=X<=10) 별 저장 (인덱스0~9사용)
	static int[] di = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int[] dj = {0, 0, -1, 1};
	
	static void bfs() {
		Queue<Cell> q = new LinkedList<>();
		for (int x = 9; x >= 0; x--) { // 생명력이 큰 순서로 번식 
			for (int s = 0; s < list.get(x).size(); s++) {
				q.offer(list.get(x).get(s));
			}
		}
		while(!q.isEmpty()) {
			Cell c = q.poll();
			if(c.life==0 && c.flag==1) { // 비활성화 
				map[c.i][c.j] = -1; // life==0 && c.flag==1 면 종료 
				continue;
			}
			if(c.time==0) continue; // 배양시간이 지나면 넘어감 
			if(c.life!=0) { // life!=0면 비활성화,  활성화에 상관없이 계속 진행 (단, 감소)
				q.offer(new Cell(c.i, c.j, c.x, c.life-1, c.time-1, c.flag));
				continue;
			}
			// c.life==0 이고 flag==0 인 경로 최초에 활성된 상태 -> 상하좌우 번식 
			q.offer(new Cell(c.i, c.j, c.x, c.x, c.time, 1));
			for (int d = 0; d < 4; d++) {
				int ni = c.i + di[d];
				int nj = c.i + dj[d];
				if(0<=ni && ni<N+K && 0<=nj && nj<N+K && map[ni][nj]==0) {
					map[ni][nj] = c.x;
					q.offer(new Cell(ni, nj, c.x, c.x, c.time-1, 0));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d9/5653_줄기세포배양.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<ArrayList<Cell>>();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			// 초기화 
			list.clear();
			for (int x = 0; x < 10; x++) { // 줄기세포생명력 1<=X<=10 ,리스트 작업시 0~9로 변경 
				list.add(new ArrayList<>());
			}
			// 입력 
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N+K][M+K]; // 세로+배양시간, 가로+배양시간 
			for (int i = K/2; i < N+(K/2); i++) { // 배열의 중간을 계산 (0, 0)->(K/2, K/2)
				st = new StringTokenizer(br.readLine());
				// 
				for (int j = K/2; j < M+(K/2); j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						int idx = map[i][j] -1; // 리스트 작업시 0부터 9까지 (중기세포 생명력 1<=X<=10)
						list.get(idx).add(new Cell(i,j,map[i][j], map[i][j],K,0));
						
					}
				}
			}
			//
			bfs();
			//
			int cnt = 0;
			for (int i = 0; i < N+K; i++) {
				
			}
		}
		
		
	}

}
