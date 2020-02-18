package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	
	static int T;
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] newMap;
	static int max;
	static int[] combi = new int[3];
	
	// 죽은 적을 표시하기 위한 클래스
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int d;
		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public int compareTo(Pos o) {
			int sd = d - o.d;
			if(sd==0) {
				return c-o.c; // 거리가 같으면 왼쪽거 정렬
			}else {
				return sd;
			}
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("res/boj/17135_캐슬디펜스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		T = Integer.parseInt(br.readLine());
//		for (int testcase = 1; testcase < T+1; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			newMap = new int[N][M];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
//			System.out.println("#"+testcase+" "+max);
//		}
			System.out.println(max);
	}
	
	static void dfs(int cnt, int start) {
		if(cnt==3) {
			// 게임 맵 초기화
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, newMap[i], 0, M);
			}
			int count = shoot(newMap);
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i < M; i++) {
			combi[cnt] = i;
			dfs(cnt+1, i+1);
		}
		
		
	}

	private static int shoot(int[][] newMap) {
		LinkedList<Pos> q = new LinkedList<>();	// 죽일 적들 담아두기
		LinkedList<Pos> deathNote = new LinkedList<>();	// 죽인 적들 담아두기
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {			// 맵의 높이 만큼 반복
			for (int j = 0; j < 3; j++) {		// 궁수의 수 만큼 반복 (3번)
				int idx = combi[j];				// 궁수의 위치
				int nr;
				for (int k = 1; k < D+1; k++) { // 성벽에서 사거리까지
					nr = N-k;
					for (int nc = 0; nc < M; nc++) {
						int d = Math.abs(N-nr)+Math.abs(idx-nc);
						// 경계 내에 있고 사거리 내에 있는 적이면
						if(nr>-1 && nr<N && nc>-1 && nc<M && d<D+1 && newMap[nr][nc]>0) {
							q.offer(new Pos(nr, nc, d));	// 죽일 적 담아두기.
						}
					}
				}
				// 죽일 수 있는 적 담아두는 작업 끝났으면 다시 시작
				if(q.size()>0) {
					Collections.sort(q);
					deathNote.offer(q.poll());	// 사거리가 제일 짧고, 왼쪽인 적을 deathNote에 추가
				}
				q.clear();
			}
			// 궁수들이 모두 쐈으니 적을 제거하기.
			for(Pos p : deathNote) {
				if(newMap[p.r][p.c]>0) {
					newMap[p.r][p.c] = 0;	// 적을 제거
					cnt++;
				}
			}
			deathNote.clear();
			moveMap(newMap);
		}
		return cnt;
	}

	private static void moveMap(int[][] newMap) {
		for (int i = N-1; i > 0; i--) {
			newMap[i] = newMap[i-1];
		}
		newMap[0] = new int[M];
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
