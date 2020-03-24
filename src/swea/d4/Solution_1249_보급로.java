package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution_1249_보급로 {
	
	static int T;
	static int result;
	
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/1249_보급로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase < T+1; testcase++) {
			result = 0;
			
			
			
			System.out.println("#"+testcase+" "+result);
		}
	}
}
