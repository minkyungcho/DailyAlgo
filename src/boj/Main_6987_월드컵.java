package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {
	
	static int[] win;
	static int[] lose;
	static int[] draw;
	static int winCnt, loseCnt, drawCnt;
	static boolean flag;
	
	static int[] g1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] g2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine(), " ");
		for (int t = 0; t < 4; t++) {
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			st = new StringTokenizer(br.readLine(), " ");
			winCnt = 0;
			drawCnt = 0;
			loseCnt = 0;
			for (int i = 0; i < 6; i++) {
				winCnt += win[i] = Integer.parseInt(st.nextToken());
				drawCnt += draw[i] = Integer.parseInt(st.nextToken());
				loseCnt += lose[i] = Integer.parseInt(st.nextToken());
			}
			flag = false;
			if(winCnt + drawCnt + loseCnt != 30) {
				flag = false;
			}else {
				solve(0);
			}
			
			System.out.print((flag ? 1 : 0) + " ");
		}
		
	}

	static void solve(int game) {
		if(flag) return;
		
		if(game == 15) {
			flag = true;
			return;
		}
		
		int t1 = g1[game];
		int t2 = g2[game];
		
		// t1 승리 
		if(win[t1]>0 && lose[t2]>0) {
			win[t1]--;
			lose[t2]--;
			solve(game+1);
			win[t1]++;
			lose[t2]++;
		}
		// t2 승리 
		if(win[t2]>0 && lose[t1]>0) {
			win[t2]--;
			lose[t1]--;
			solve(game+1);
			win[t2]++;
			lose[t1]++;
		}
		// 무승부 
		if(draw[t1]>0 && draw[t2]>0) {
			draw[t1]--;
			draw[t2]--;
			solve(game+1);
			draw[t1]++;
			draw[t2]++;
		}
		
	}

}
