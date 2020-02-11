package com.ssafy.datastruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * 	Map은 key를 이용해서 value를 관리
 * 	- key 값은 유니크하게 유지
 * 	- value는 유니크하지 않아도 됨
 */

public class MapTest {

	public static void main(String[] args) {
		
		/**
		 * HashMap<key, value> 로 선언
		 */
//		HashMap<K, V>
		HashMap<String, Integer> map = new HashMap<>();
		
		// put(key, value) : value와 key를 쌍으로 저장
		map.put("hello", 3);
		map.put("ssafy", 5);
		map.put("hello", 7); // 똑같은 key로 다른 값을 거장하면 덮어쓰기가 됨
		System.out.println(map);
	
		// key만 추출
		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.println(key+":"+map.get(key));
		}
		
		Collection<Integer> values = map.values();
		for(Integer val : values) {
			System.out.println(val);
		}
		
		// get(key) : key에 해당하는 value를 추출한다.
		System.out.println("ssafy : "+map.get("ssafy"));
		System.out.println("ssafy : "+map.get("kk"));
	
		// remove(key) : key에 해당하는 value를 삭제
		System.out.println(map.remove("ssafy"));
		
		// containsKey(key) : 해당 키가 있는지 여부
		System.out.println(map.containsKey("hello"));
		System.out.println(map.containsKey("ssafy"));

		// containsValue(value) : 해당 value가 있는지 여부
	}

}
