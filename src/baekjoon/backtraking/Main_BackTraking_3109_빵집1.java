package baekjoon.backtraking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BackTraking_3109_빵집1 {
	public static int R, C;
	public static int answer;
	public static char [][] map;
//	빵집에서 최대 뚫을 수 있는 송유관은 1개이고 맨 위에서부터 뚫어야 아래 빵집도 뚫을 기회가 있어서 우상, 우, 우하 순으로 순회를 해 본다. 
	public static int [][] dir= {{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/backjun_3109_빵집.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i]  = in.readLine().toCharArray();
		}
		int count = 0;
		for (int i = 0; i < R; i++) {
			if(back(i,0)) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean back(int r, int c) {
		if(c==C-1) {
			return true;
		}
		map[r][c]='x';
		int nr, nc;
		for (int i = 0; i <3; i++) {
			nr = r+dir[i][0];
			nc = c+dir[i][1];
			if(nr>-1 && nr<R &&  nc<C&& map[nr][nc]!='x' ) {
				if(back(nr,nc)) {  //송유관 한개를 뚫었으면 다른 송유관은 뚫으면 안되기 때문에 다른 방향으로 가지 못하게  리턴한다. 
					return true;
				}
			}
		}
		//visit[r][c]=false;   //  => 시간 터짐   어차피 못가는 길은 다른 길에서도 그 길을 못한다. 
		return false;
	}
}
