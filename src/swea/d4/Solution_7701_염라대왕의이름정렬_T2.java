package swea.d4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution_7701_염라대왕의이름정렬_T2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // �̸��� ���� 1~20,000
			
			String[] name = new String[N];
			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			
			Arrays.sort(name, new Comparator<String>() {
				public int compare(String pre, String next) {
					if (pre.length() != next.length()) { // ������ ���� ª������
						return pre.length() - next.length();
					} else { // ���̰� ������, ������
						return pre.compareTo(next); // ��������
					}
				}
			});
			
//			System.out.println(Arrays.toString(name));
			// �ߺ�����
			System.out.println("#"+testCase);
			
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if (!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		} // end of testCase
	} // end of main
} // end of class

