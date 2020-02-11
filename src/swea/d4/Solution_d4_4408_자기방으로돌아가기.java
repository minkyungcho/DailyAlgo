package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_4408_자기방으로돌아가기 {

	static int T;
	static int N;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d4/4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());
		int result;
		for (int testcase = 1; testcase < T + 1; testcase++) {
			int[] room = new int[201];
			result = 0;
			N = Integer.parseInt(br.readLine().trim());
			int nowRoom;
			int backRoom;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a%2!=0) {
					nowRoom = a/2+1;
				}else {
					nowRoom = a/2;
				}
				if(b%2!=0) {
					backRoom = b/2+1;
				} else {
					backRoom = b/2;
				}
				if(backRoom > nowRoom) {
					for (int j = nowRoom; j < backRoom + 1; j++) {
						room[j] += 1;
					}
				} else if (nowRoom > backRoom) {
					for (int j = backRoom; j < nowRoom + 1; j++) {
						room[j] += 1;
					}
				} 
				
			}
			
			for(int r : room) {
				if(result < r) {
					result = r;
				}
			}

			System.out.println("#" + testcase + " " + (result));
			
		}

	}

}
