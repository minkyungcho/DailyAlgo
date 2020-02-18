package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_2667_단지번호붙이기_DFS_Recursive {

	static int no = 1;
	static int[][] map;
	static int[][] visit;
	static int N;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/boj/2667_단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];

		// 데이터 읽기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 배열을 전체 순회하면서 아파트(1)를 찾으면 dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 아파트이면서 방문하지 않은 아파트
				if (map[i][j] == 1) { // 아파트
					dfs(i, j, 1); // 새로운 단지
					no++; // 새로운 단지 번호 부여
				}

			}
		}

		// visit 배열 순회하면서 단지마다 아파트 수 count
		int[] count = new int[no];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) { // 아파트
					count[map[i][j]]++;
				}
			}
		}

		// count 배열 정렬헤서
		Arrays.sort(count);

		// 출력
		for (int i = 2; i <= no + 1; i++) {
			System.out.println(count[i]);
		}

	}

	private static void dfs(int r, int c, int no) {
		map[r][c] = no;
		for (int d = 0; d < 4; d++) { // 현재 아파트에 사방에 인접된 아파트가 있는지 확인
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc]==1) {
				dfs(nr, nc, no);
			}
		}
	}

}
