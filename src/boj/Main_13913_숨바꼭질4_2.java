package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4_2 {

	static int N, K; // 수빈위치, 동생위치 
//	static boolean[] visited;
	static int[] path; // 이전위치를 기억하기 위한 path 배열 
	// 각 자리에는 그 자리에 오기 바로 전 위치를 기록한다. 
	
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
//		visited = new boolean[100001]; // 0 ~ 100000
		path = new int[100001];
		Arrays.fill(path, -1); // 그 전 위치값에 해당하지 않는 -1으로 배열을 초기화한다. 
		
		System.out.println(bfs());
		
		Stack<Integer> stack = new Stack<>();
		int temp = K;
		do {
			stack.push(temp);
			temp = path[temp];
		}while(temp != -1); // temp 가 -1이면 그 위치가 시작점임. 자기를 오게만든 이전 위치가 없음.
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		
		// 지금 수빈이의 위치, 걸린시간 
//		Queue<int[]> queue = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		// 수빈이의 위치만 기록한다. visit 대신 
//		visited[N] = true; // 수빈이의 위치 true로 마킹
//		queue.offer(new int[] {N,0});
		queue.offer(N);
		
		int nx; // 새로운 x 좌표
		
		int depth = 0;
		while(!queue.isEmpty()) {
//			int[] cur = queue.poll();
			int cur = queue.poll();
			
			// 동생위치와 같다면 
			if(cur == K) {
				// 동생을 만난 가장 최소 시간을 구하는 것. 큐에는 지금 depth보다 큰 애들만 들어간다. 지금 depth가 최소임. 
				return depth;
			}
			// 겯는 경우 
			// 위
			nx = cur - 1; 
			if(nx>=0 && path[nx]==-1) { // 위로 가는 경우이기 때문에 nx<=100000 은 불필요
				// 
				depth++;
				path[nx] = cur;
				queue.offer(nx);
			}

			// 아래 
			nx = cur + 1; 
			if(nx<=100000 && path[nx]==-1) { // 아래로 가는 경우이기 때문에 nx>=0 은 불필요 
				depth++;
				path[nx] = cur;
				queue.offer(nx);
			}
			
			// 순간이동 하는 경우
			nx = cur << 1; 
			if(nx<=100000 && path[nx]==-1) { // 순간이동하는 경우이기 때문에 nx>=0 은 불필요 
				depth++;
				path[nx] = cur;
				queue.offer(nx);
			}
		}
		return -1;
	}

}
