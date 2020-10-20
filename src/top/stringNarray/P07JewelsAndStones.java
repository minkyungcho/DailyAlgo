package top.stringNarray;

import java.util.HashSet;
import java.util.Set;

public class P07JewelsAndStones {

	public static void main(String[] args) {
		
		String J = "aA";
		String S = "aAAbbbb";
		System.out.println(solve(J,S));
		
	}
	
	public static int solve(String jew, String stone) {
		Set<Character> set = new HashSet<>();
		for(char j:jew.toCharArray()) {
			set.add(j); // a, A
		}
		
		int cnt = 0;
		for(char s:stone.toCharArray()) {
			if(set.contains(s)) {
				cnt++;
			}
		}
	
		return cnt;
	}

}
