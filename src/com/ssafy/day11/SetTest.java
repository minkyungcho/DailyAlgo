package com.ssafy.day11;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {

		// Set : 중복데이터 제거(유일한 데이터만 저장), (저장되는)순서가 일정치 않다. null 허용? O

//		Set<String> set = new HashSet<>();
		Set<String> set = new TreeSet<>(); // 정렬된 set : null 허용? X

		// 데이터 추가
		set.add("홍길동");
		set.add("길라임");
		set.add("김주원");
		set.add("홍길동");
		set.add("이순신");
		set.add("홍길동");
//		set.add(null);
//		set.add(null);

		System.out.println("Set에 저장된 요소 개수 : " + set.size());

		// 모든 요소 출력
		Iterator<String> it = set.iterator();
		// 열거형 인터페이스

		while (it.hasNext()) { // it에 열거된 데이터가 존재한다면 true 리턴
			System.out.println(it.next()); // 데이터 뽑아오기
		}

		// 로또번호 출력 ==> 중복되지 않는 1~45의 숫자 데이터를 6개 출력(정렬)!
		Set<Integer> lotto = new TreeSet<>(); // 정렬된 set : null 허용? X
		Random r = new Random();
		while (lotto.size() != 6) {
			int ran = r.nextInt(45) + 1;
			lotto.add(ran);
		}
		System.out.println(lotto);

		Iterator<Integer> it2 = lotto.iterator();
		while (it2.hasNext()) { // it에 열거된 데이터가 존재한다면 true 리턴
			System.out.println(it2.next()); // 데이터 뽑아오기
		}

	}

}
