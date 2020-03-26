package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이_r {
	
	static int count, row, col;
	static int endR, endC;
	static int[][] map;
	static boolean[][][] visited;
	static int[][][] dir = {
			{ {-1,0},{1,0},{0,-1},{0,1} }, // 원숭이 dir 
			{ {-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1} } // 말 dir
	};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		count = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[count+1][row][col];
		
		endR = row - 1;
		endC = col - 1;
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(move());
	}

	private static int move() {
		
		int r=0, c=0, cnt=0, moveCnt=0, temp[], nr, nc;
		
		Queue<int[]> q = new LinkedList<>();
		visited[count][0][0] = true; // 맨 처음 좌표 방문 표시 
		
		q.offer(new int[] {count, 0, 0, 0}); // {말남은횟수, r, c, 동작수}
		
		while(!q.isEmpty()) {
			
			temp = q.poll();
			cnt = temp[0];
			r = temp[1];
			c = temp[2];
			moveCnt = temp[3];
			
			if(r==endR && c==endC) return moveCnt;
			
			for (int h = 0; h < 2; h++) { // h=0 : 원숭이,     h=1 : 말 
				
				if(h==1) { // 말 일때 
					if(cnt==0) break; // 말 움직임 다 끝난 경우 : 다음 큐에 있는 애 봐야함. for문 break하고 while문으로 가야함.
					else cnt--; // 말 움직임 남아있는 경우 : 말움직임 1 줄이고 움직인다.  
				}
				
				for (int d = 0; d < dir[h].length; d++) {
					
					
					nr = r + dir[h][d][0];
					nc = c + dir[h][d][1];
					
					if(0<=nr && nr<row && 0<=nc && nc<col && map[nr][nc]==0 & !visited[cnt][nr][nc]) {
						visited[cnt][nr][nc] = true;
						q.offer(new int[] {cnt, nr, nc, moveCnt+1});
					}
				}
			}
			
		}
		
		
		return -1;
	}

}
