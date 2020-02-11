package com.ssafy.queue;
import java.util.ArrayDeque;
public class MyChew_array {
	public static void main(String[] args) {
		
		int N = 20; // 마이쭈 개수
		int person = 1; // 사원번호
		
		// int형 담는 큐.
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		while(true) {
			
			int p = (person++<<8)+1;
			
			// 1번 사원 줄서기 && 새로운 사원들의 줄 서기
			queue.offer(p);
			
			// 제일 앞에 있는 사원 뽑기
			p = queue.poll();
			
			// 마이쭈 개수 증가시키고 전체 개수에서 빼기
			int num = (byte) p; //가져갈 개수 가져오기
			int no = p>>8; // 사원번호 추출
			N -= num;

			// 전체 마이쭈 개수가 0보다 작거나 같아졌으면 마지막 마이쭈를 가져감. break;
			if(N <= 0) {
				System.out.printf("%d번 사원이 마지막 마이쭈 %d개를 가져갔습니다.\n", no, (num+N));
				break;
			}
			
			// 사원들이 몇개의 마이쭈를 가져갔는지 출력해주기.
			System.out.printf("%d번 사원이 %d개의 마이쭈를 가져갔습니다. 남은 개수는 %d개 입니다.\n", no, num, N);
			
			// queue에서 빠져나온 사원이 다시 줄 선다.
			queue.offer(++p); // 다음번에 가져갈 개수 늘리기
		}
	}
}
