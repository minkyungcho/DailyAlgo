package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1812_수정이의타일자르기_T {
	
	static class Rectangle implements Comparable<Rectangle>{
		int min, max;
		
		public Rectangle(int width, int height) {
			if(width<height) {
				min = width;
				max = height;
			}else {
				min = height;
				max = width;
			}
		}

		@Override
		public int compareTo(Rectangle o) {
			// 내림차순 : 상대 - 나
			// 오른차순 : 나 - 상대 
			return o.min - this.min; // 내림차순 정렬 
		}
	}
	
	static int N, M, size[], cnt;
	static PriorityQueue<Rectangle> queue;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb =  new StringBuilder();
		for (int tc = 1; tc < TC+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			} // 만들고자하는 정사각형의 크기(2^k) 입력 (k)
			
			cut();
			sb.append("#"+tc+" "+cnt+"\n");
			
		}
		System.out.println(sb.toString());
	}

	private static void cut() {
		// 가장 큰 크기의 정사각형부터 만들기 
		Arrays.sort(size);
		queue = new PriorityQueue<Rectangle>();
		queue.offer(new Rectangle(M, M));
		++cnt;
		
		// 오름차순으로 정렬된 배열을 맨 뒤에서부터 접근한다. 마치 내림차순 배열에 접근하는듯이 
		for (int i = N-1; i >= 0; i--) {
			go(1<<size[i]); // 1<<2  : 4
		}
		
	}

	private static void go(int size) {
		// queue에서 poll() : min값이 최대인 직사각형들이 뽑아짐 
		// 직사각형의 최소변의 길이가 size보다 같거나 크면 : 원하는 크기의 정사각형을 만들 수 있아.
		Rectangle r = queue.poll();
		if(r.min >= size) {
			queue.offer(new Rectangle(r.min-size, size));
			queue.offer(new Rectangle(r.min, r.max-size));
			
		}else { // 아니면 : 원하는 크기의 정사각형을 만들 수 있음
			queue.offer(r); // 사용하지 않은 타일 다시 넣기 
			queue.offer(new Rectangle(M, M-size)); // 새 타일 구매
			++cnt; // 타일 개수 증가 
		}
		
	}

}
