package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {
	
	static int T = 10;
	static int result;
	static int t;
	static int roadNum;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1219_길찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int testcase = 1; testcase < T+1; testcase++) {

			result = 0;
			map = new int[100][100];
			visit = new boolean[100];
			LinkedList<Integer> start = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			roadNum= Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int a, b;
			for (int n = 0; n < roadNum; n++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				map[a][b]++;
				if(a==0) {
					start.add(b);
				}
			}
			
//			print();
			
			for (int i = 0; i < start.size(); i++) {
				dfs(start.get(i));
			}
			
			System.out.println("#"+testcase+" "+result);
		}
	}
	
	private static void dfs(int cur) {
		Stack<Integer> s = new Stack<>();
		s.push(cur);
		while(!s.isEmpty()) {
			cur = s.pop();
			if(!visit[cur]) {
				visit[cur] = true;
				for (int ad = 0; ad < 100; ad++) {
					if(map[cur][ad]==1 && !visit[ad]) {
						if(ad==99) {
							result = 1;
							return;
						}
						s.push(ad);
					}
				}
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
