package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사_조민경 {
	static String[] tree;
	static char[] save;
	static int N;
	static int idx;
	public static void main(String[] args) throws Exception {

		int T = 10;
		System.setIn(new FileInputStream("res/swea/d4/1233_사칙연산유효성검사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase < T + 1; testcase++) {
			idx = 1;
			int result = 1;
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			save= new char[N+1];
			String s;
			for (int i = 1; i < N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				s = st.nextToken();
				switch (s) {
				case "+":
					tree[i] = s;
					break;
				case "-":
					tree[i] = s;
					break;
				case "*":
					tree[i] = s;
					break;
				case "/":
					tree[i] = s;
					break;
				default:
					tree[i] = s;
					int n = Integer.parseInt(s);
					break;
				}
			}
			inorder(1);
			
			for(int i=1; i<N; i+=2) {
				if(save[i+1]-save[i]>0) {
					result = 0;
					break;
				}
			}
			System.out.println("#" + testcase + " " + result);
		}

	}

	public static void inorder(int index) {

		// index가 N보다 작거나 같을때까지만 순회함
		// vertex가 경계 내에 있고, data가 있다.
		if (index < N + 1 && !tree[index].equals("0")) {
			// 왼쪽 자식 방문 : vertex의 index*2
			inorder(index << 1); // index*2
			// vertex(현재 노드) 처리
//			System.out.print(tree[index] + " ");
			save[idx++] = tree[index].charAt(0);
			// 오른쪽 자식 방문 : vertex의 index*2+1
			inorder((index << 1) + 1); // index*2+1
		}
	}

}
