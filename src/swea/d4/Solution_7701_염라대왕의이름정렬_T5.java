package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class Solution_7701_염라대왕의이름정렬_T5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // �̸��� ���� 1~20,000
			
			TreeSet<String>[] tsrr = new TreeSet[51]; 
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i] = new TreeSet<String>(); // �迭 �� ĭ�� �����ؼ� �ֱ�
			}
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}
			
//			for (int i = 0; i < tsrr.length; i++) {
//				System.out.println(tsrr[i]);
//			}
			// �ߺ�����
			sb.append('#').append(testCase).append('\n');
			for (int i = 1; i < tsrr.length; i++) {
				for (String string : tsrr[i]) {
					sb.append(string).append('\n');
				}
			}
		} // end of testCase
		System.out.print(sb);
	} // end of main
} // end of class

