package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	
	static int T;
	static int R;
	static int C;
	static int result=0;
	static int[][] map;
	static int[][] newMap;
	static boolean[][] visit;
	static int[][] dir= {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static LinkedList<int[]> q;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("res/boj/7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		T = Integer.parseInt(br.readLine());
//		for (int testcase = 1; testcase < T+1; testcase++) {
			q = new LinkedList<>();
			result=0;
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			newMap = new int[R][C];
			visit = new boolean[R][C];
			
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 토마토가 없는 칸은 visit한 것이라고 가정
					if(map[i][j]==-1) {
						visit[i][j] = true;
					}else if(map[i][j]==1) {
						q.offer(new int[] {i, j, 0});
					}
				}
			}
			int r, c, nr, nc;
			// 게임 맵 초기화
			for (int k = 0; k < R; k++) {
				System.arraycopy(map[k], 0, newMap[k], 0, C);
			}
			int[] tmp;
			while(!q.isEmpty()) {
				for (int i = 0; i < q.size(); i++) {
					tmp = q.poll();
					r = tmp[0];
					c = tmp[1];
					result = tmp[2]+1;
					for (int d = 0; d < 4; d++) {
						nr = r + dir[d][0];
						nc = c + dir[d][1];
						if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc]==0 && !visit[nr][nc]) {
							map[nr][nc] = 1;
							visit[nr][nc] = true;
							q.offer(new int[] {nr, nc, result});
//							result++;
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j]==0) {
						result=0;
					}
				}
			}
			
//			System.out.println("#"+testcase+" "+(result-1));
			System.out.println(result-1);
//		}
		
	}
}
