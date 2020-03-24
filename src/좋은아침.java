import java.util.Arrays;

public class 좋은아침 {

	static char[] chars = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		// chars에서 3개를 고르는 순열을 작성해보세요.
		int r = 3;
		System.out.println("=====순열======");
		makePermutation1(r, new char[r], new boolean[chars.length]);
		System.out.println("=====중복 순열======");
		makePermutation2(r, new char[r]);

	}

	/**
	 * 순열
	 * @param r       : 뽑아야 할 숫
	 * @param temp    : 뽑힌 녀석
	 * @param visited : 중복 방지
	 */
	static void makePermutation1(int r, char[] temp, boolean[] visited) {
		// base rule
		if (r == 0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}

		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[r - 1] = chars[i];
				makePermutation1(r - 1, temp, visited);
				visited[i] = false;
			}
		}

	}

	/**
	 * 중복순열
	 * @param r    : 뽑아야 할 숫
	 * @param temp : 뽑힌 녀석
	 */
	static void makePermutation2(int r, char[] temp) {
		// base rule
		if (r == 0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}

		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			temp[r - 1] = chars[i];
			makePermutation2(r - 1, temp);
		}

	}

}
