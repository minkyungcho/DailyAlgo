package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_d2_1928_Base64Decoder {

	public static void main(String[] args) throws Exception {
		
		String[] base642 = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U"};
		char[] base64 = new char[64];
		
		for(char a='A'; a<='Z'; a++) {
			base64[a-97]=a;
		}
		for(int i=26;i<52;i++) {
			base64[i]= (char)(i);
		}
		
		System.setIn(new FileInputStream("res/swea/d2/1928_Base64Decoder.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String result;
		
		for(int test_case=1; test_case<T+1; test_case++) {
			result = "";
			
			String[] line = br.readLine().split("");
//			System.out.println(Arrays.toString(line));
			
			String bin = Integer.toBinaryString(Integer.parseInt(line[0]));
			
			System.out.println(bin);
			System.out.println("#"+test_case+" "+result);
			return;
		}
	}
}
