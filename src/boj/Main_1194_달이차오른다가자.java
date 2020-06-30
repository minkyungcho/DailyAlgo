package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	static int N, M;
	static char[][] map;
	static int startR, startC;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				if(map[r][c]=='0') {
					startR = r;
					startC = c;
				}
			}
		}
		
//		for(char[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(startR+" "+startC);
		
	}

}
