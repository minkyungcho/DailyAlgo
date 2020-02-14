package baekjoon.backtraking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BackTraking_3109_빵집2 {

	static char[][] map;
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int cnt = 0;
		for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		for (int i = 0; i < R; i++) if(back(i, 0)) ++cnt;
		System.out.println(cnt);
	}

	private static boolean back(int r, int c) {
		if(r < 0 || r == R || map[r][c] == 'x') return false;
		map[r][c] = 'x';
		if(c == C - 2) return true;
		return back(r - 1, ++c) || back(r, c) || back(r + 1, c);
	}
}


