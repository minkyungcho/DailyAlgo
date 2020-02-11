package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	
	static int N;
	static int[][] temp;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("res/jungol/im/1828_냉장고.txt"));
//		System.setIn(new FileInputStream("res/1828_냉장고.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		temp = new int[N][2];
		int result=0;
		for (int i = 0; i< N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// sort 오름차순  왜 이걸로는 안돼..?
		for(int i=0; i<N; i++) {
			for (int j=i+1; j < N; j++) {
				if(temp[i][1]>temp[j][1]) {
					int t = temp[j][1];
					int tt = temp[j][0];
					temp[j][1] = temp[i][1];
					temp[j][0] = temp[i][0];
					temp[i][1] = t;
					temp[i][0] = tt;
				}
				
			}
		}
		
		
		// API 사용
//		Arrays.sort(temp, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[1] - o2[1];
//			}
//		});
		
		int last = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(last < temp[i][0]) {
				result++;
				last = temp[i][1];
			}
		}
		
		// 출력 
//		for(int i=0; i<N; i++ ) {
//			System.out.println(temp[i][0]+" "+temp[i][1]);
//		}
		
		System.out.println(result);
		
	}

}
