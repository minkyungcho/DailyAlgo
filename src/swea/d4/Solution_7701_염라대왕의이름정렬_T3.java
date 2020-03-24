package swea.d4;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
public class Solution_7701_염라대왕의이름정렬_T3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // �̸��� ���� 1~20,000
			
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
				name.add(sc.next()); // �ߺ� ����
			}
			
//			System.out.println(name);
			// �ߺ�����
			System.out.println("#"+testCase);
			for (String string : name) {
				System.out.println(string);
			}
		} // end of testCase
	} // end of main
} // end of class

