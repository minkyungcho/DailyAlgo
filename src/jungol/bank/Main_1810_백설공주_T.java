package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1810_백설공주_T {

	static int n = 9;
	static int r = 7;
	static int[] numbers;	// 9명의 난장이 수
	static int[] result;	// 조합을 담을 배열
	static int target = 100;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/jungol/bank/1810_백설공주2.txt"));
		Scanner sc = new Scanner(System.in);
		numbers = new int[n];
		result = new int[r];
		
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		combination(0, 0, 0);
		
	}
	/**
	 * 조합을 구하는 함수
	 * @param cnt	배열의 index
	 * @param start	조합을 시작할 수
	 */
	private static void combination(int cnt, int start, int sum) {
		
		if(cnt == r) {
			if(sum == target) {
				for(int s : result) {
					System.out.println(s);
				}
			}
			return;
		}
		
		if(sum >= target) return; // r개가 아닌데도 sum이 target보다 크면 더 볼 필요 없으므로 return
		
		for(int i=start; i<n; i++) {
			result[cnt] = numbers[i];
			combination(cnt+1, i+1, sum+result[cnt]);
		}
		
	}

}
