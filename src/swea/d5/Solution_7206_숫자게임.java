package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_7206_숫자게임 {
	
	static HashMap<Integer, Integer> memo;
	static int N;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/swea/d5/7206_숫자게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			memo = new HashMap<Integer, Integer>();
			int cnt = game(N);
			
			System.out.println("#"+tc+" "+cnt);
		}
		
	}

	private static int game(int n) {
		// n이 10미만이면 리턴 0 
		if(n < 10) {
			return 0;
		}
		int max = 0;
		String s = n+""; // 숫자를 문자형으로 바꾸기 
		int len = s.length()-1;
		/*
		 * 123		0 : 안쪼갠 경
		 * 1 23		1 :	첫번째 위치에서 숫자를 쪼갠다.
		 * 12 3		10: 두번째 위치에서 숫자를 쪼갠다.
		 * 1 2 3	11: 첫번째 두번째 위치에서 숫자를 쪼갠다.
		 */
		// 부분집합을 이용해서 1위치에서 숫자를 쪼갠 후 곱한다.
		for (int i = 1, size = 1<<len; i < size; i++) {
			int num = s.charAt(0)-'0';
			int mul = 1; 
			for (int j = 0; j < len; j++) {
				if( (i & (1<<j)) == 0) { // 쪼개는 위치가 아님.
					num = num*10 + s.charAt(j+1)-'0';
				}else {
					mul *= num;
					num = s.charAt(j+1)-'0';
				}
			}
			mul *= num; // 마지막 조각을 연산 
			int cnt = 0;
			if(memo.containsKey(mul)) { // 숫자가 메모한 경우라면 
				cnt = memo.get(mul);
			}else {	// 메모한 곳에 숫자가 없으면 새로 구해야 한다.
				cnt = game(mul);
				memo.put(mul, cnt);
			}
			
			max = Math.max(max, cnt);
		}
		return max+1;
	}

}
