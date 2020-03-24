package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;
public class Solution_7701_염라대왕의이름정렬_T4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // �̸��� ���� 1~20,000
			
			TreeSet<String> name = new TreeSet<String>(new Comparator<String>() {
				public int compare(String pre, String next) {
					if (pre.length() != next.length()) { // ������ ���� ª������
						return pre.length() - next.length();
					} else { // ���̰� ������, ������
						return pre.compareTo(next); // ��������
					}
				}
			});
			for (int i = 0; i < N; i++) {
				name.add(br.readLine()); // �ߺ� ����
			}
			
//			System.out.println(name);
			// �ߺ�����
			sb.append('#').append(testCase).append('\n');
			for (String string : name) {
				sb.append(string).append('\n');
			}
		} // end of testCase
		System.out.print(sb);
	}
} // end of class

