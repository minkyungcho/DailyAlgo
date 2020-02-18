package com.ssafy.day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		Map ==> 저장데이터(키값, 데이터값)
		
		Map<K, V>
			- 사물함 클래스 (책:데이터, 열쇠:키)
			- K:Key의 자료형, V:Value의 자료형
			- Key는 보통 문자열 사용, Value(저장데이터)는 Object
			- Key값은 중복 X (유일한 값을 갖는다)
			
			- 저장: map.put(키값, 저장데이터);
			- 조회: 자료형 변수명 = map.get(키값);
		 */

		Map<String, Object> map = new HashMap<>();
		
		// 데이터입력 ("홍길동", 13, "학생")
		// map.put(String key, Object value);
		// 데이터입력 ("홍길동", 13, "학생")
		map.put("name", "홍길동");
		map.put("age", 13);
		map.put("job", "학생");
		System.out.println(map);
		
		Map<String, Object> map2 = new HashMap<>();
		// 데이터입력 ("홍길동","길라임", "학생")
		map2.put("k1", "홍길동");
		map2.put("k2", "김주원");
		map2.put("k3", "길라임");
		map2.put("k4", "김유신");
		map2.put("k3", "이순신"); // 중복 키 값 존재 : 덩퍼쓰기 (수정)
		
		// 특정 데이터 조회, 출력 (k2에 저장된 데이터를 cmc 력)
		// map2.remove(Object Key);
		
		//특정 키에 저장된 데이터 수정
		map2.replace("4", "하유신");
//		Collecion c = ma[evlaue]
//		Iterator<String> it = col.iterator();
		
		
		
		
		
		// map2의 key값만 띠러 얻어오기
		System.out.println("<<전체 map2의 키 출력>>");
		Set<String> set = map2.keySet();
		Iterator<String> keyset = set.iterator();
		while(keyset.hasNext()) {
			String key = keyset.next();
			System.out.println(key+"에 저장된 데이터: ");
		}
		
		
		/* 문제 Map m3; 에 Person클래스 (4, "길동", 13, "학생") 		
								   ("소나타", 4, 10)
					거리데이터(10km)를 저장하시오/
		*/
		
//		Person P = new Person(4, "길동", 13, "학생");
//		Car c = new Car();
		String d = "10km";
		Map<String, Object> m3 = new HashMap<>();
//		m3.put("person", p);
//		m3.put("car", c);
		m3.put("distance", d);
		// 문제) ㅇ저장된 거리를 측정
		System.out.println("거리:"+m3.get("anyway key"));
		System.out.println("거리:"+m3.get("null"));
		
		// 문제)
		
		
		
	}
}
