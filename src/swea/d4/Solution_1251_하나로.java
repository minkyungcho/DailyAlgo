package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	
	static int T;
	static int N; // 섬 
	static double E; // 환경부담 세율   
	static long[][] islands; // 섬 좌표 담고 있는 배열 
	static double result;
	static long[][] graph; // 정점들 간의 거리 그래프 
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stR,stC;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			islands = new long[N][2]; 
			stR = new StringTokenizer(br.readLine(), " ");
			stC = new StringTokenizer(br.readLine(), " ");
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i] = new long[] {Long.parseLong(stR.nextToken()), Long.parseLong(stC.nextToken())};
			}
			
			for(long[] a : islands) {
				System.out.println(Arrays.toString(a));
			}
			
			
			System.out.println("#"+tc+" "+result);
			
			if(tc == 2) break;
		}
		
	}

}
