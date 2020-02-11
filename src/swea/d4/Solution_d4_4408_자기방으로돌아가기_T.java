package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_4408_자기방으로돌아가기_T {

	static int T;
	static int N;
//	static int[] room;
	static int cnt;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d4/4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());
		int result;
		for (int testcase = 1; testcase < T + 1; testcase++) {
			int[] room = new int[201];
			int[] sameRoom = new int[201];
			result = 0;
			cnt = 0;
			N = Integer.parseInt(br.readLine().trim());
			int nowRoom;
			int backRoom;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				nowRoom = Integer.parseInt(st.nextToken());
				backRoom = Integer.parseInt(st.nextToken());
				
				if(nowRoom%2!=0) {
					nowRoom++;
				}
				if(backRoom%2!=0) {
					backRoom++;
					
				} 
				
				nowRoom/=2;
				backRoom/=2;
				
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
