package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_d4_4366_정식이의은행업무 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/4366_정식이의은행업무.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str2 = br.readLine();
			String str3 = br.readLine();
			int ans = 0;
			char[] arr2 = new char[str2.length()];
			char[] arr3 = new char[str3.length()];
			arr2 = str2.toCharArray();
			arr3 = str3.toCharArray();
			String str22;
			String str33;
			List<Integer> intlist2 = new LinkedList<>();
			List<Integer> intlist3 = new LinkedList<>();
			for (int i = 0; i < arr2.length; i++) {
				if(arr2[i]=='0') {
					arr2[i] = '1';
					str22 = new String(arr2);
					intlist2.add(Integer.parseInt(str22, 2));
					arr2[i] = '0';
				}else {
					arr2[i] = '0';
					str22 = new String(arr2);
					intlist2.add(Integer.parseInt(str22, 2));
					arr2[i] = '1';
				}
			}
			
			for (int i = 0; i < arr3.length; i++) {
				if(arr3[i]=='0') {
					arr3[i] = '1';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '2';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '0';
				} else if(arr3[i]=='1') {
					arr3[i] = '2';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '0';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '1';
				} else if(arr3[i]=='2') {
					arr3[i] = '1';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '0';
					str33 = new String(arr3);
					intlist3.add(Integer.parseInt(str33, 3));
					arr3[i] = '2';
				}
			}
			
			out:
			for(int num2 : intlist2) {
				for(int num3 : intlist3) {
					if(num2 == num3) {
						ans = num2;
						break out;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
