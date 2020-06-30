package swea.d9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static class BC{
		int x;
		int y;
		int c;
		int p;
		int idx;
		public BC(int x, int y, int c, int p, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + ", idx=" + idx + "]";
		}
		
	}
	
	static int max;				// 최대충전량 
	static int M;				// 이동 횟수 
	static int A;				// BC의 개수 
	static int[] aPath, bPath;	// a, b의 이동 좌표 
	static int ax, ay, bx, by;	// a, b의 좌표 
	static BC[] list;
	static LinkedList<BC> containerA = new LinkedList<>();
	static LinkedList<BC> containerB = new LinkedList<>();
					   // 상  우  하  좌  
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d9/5644_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 데이타 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			aPath = new int[M];
			bPath = new int[M];
			list = new BC[A];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				aPath[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bPath[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new BC(	Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									i);
			}
			// 초기화 
			max = 0;
			ax = ay = 1;
			bx = by = 10;
			
			
			// 이동 좌표 만큼 반복하면서 범위 내에 있는 BC 찾고 충전 가능한 Max값으로 충전 후 이동 
			for (int i = 0; i < M; i++) {
				max += calc(); 		// 충전 
				ax += dc[aPath[i]];	// 이동 
				ay += dr[aPath[i]];
				bx += dc[bPath[i]];
				by += dr[bPath[i]];
			}
			max += calc(); // 마지막 이동에 대한 충전 
			// 결과 출력 
			System.out.println("#"+tc+" "+max);
		}
		
	}

	private static int calc() {
		// BC 개수 만큼 반복해서 범위 내에 있으면 keep
		for(BC bc : list) {
			if(isRange(ax, ay, bc)) {
				containerA.add(bc);
			}
			if(isRange(bx, by, bc)) {
				containerB.add(bc);
			}
		}
		
		// max 값 구하기 
		int val = 0;
		int sizeA = containerA.size();
		int sizeB = containerB.size();
		
		if(sizeB == 0) { // A만 BC가 있는 경우 
			for(BC bc : containerA) {
				val = Math.max(val,  bc.p);
			}
		}else if(sizeA == 0) { // B만 BC가 있는 경우 
			for(BC bc : containerB) {
				val = Math.max(val,  bc.p);
			}
		}else if(sizeA>0 && sizeB>0) { // A, B 모두 BC가 있는 경우 
			for(BC bcA : containerA) {
				for(BC bcB : containerB) {
					if(bcA.idx == bcB.idx) { // 같은 BC 내에 A, B 모두 있는 경우 
						val = Math.max(val, bcA.p); // A, B 아무거나 
					}else { // 각각 BC 내에 A, B 모두 있는 경우
						val = Math.max(val, bcA.p+bcB.p); 
					}
				}
			}
		}
		
		// container 초기화 
		containerA.clear();
		containerB.clear();
		
		return val;
	}

	private static boolean isRange(int x, int y, BC bc) {
		int d = Math.abs(x - bc.x) + Math.abs(y - bc.y); 
		return d <= bc.c ? true : false;
	}

}
