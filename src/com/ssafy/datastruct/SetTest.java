package com.ssafy.datastruct;

import java.util.HashSet;

/**
 *	Set
 *	- 데이터의 유니크성을 보장 => 중복해서 저장하지 않음
 *	- index가 없어서 추출할땐 불편
 *	- add(Object o), contains(Object o), remove(Object o)듣
 *	  equals(Object o)와 hashcode()를 호출해서 동일한 데이터가 있는지 검사한다.
 */

public class SetTest {
	
	public static void main(String[] args) {
		
		HashSet<Object> set = new HashSet<>();
//		Mychew_class.Person p = new Mychew_class.Person(1,1);
		
		System.out.println(set.add("hello"));
		System.out.println(set.add("hello"));
//		System.out.println(set.add(p));
//		System.out.println(set.add(new Mychew_class.Person(1,1)));
		System.out.println(set);
		System.out.println(set.size());
		
		System.out.println("is exist hello :"+set.contains("hello"));

		
		// set은 index가 없어서 특정 위치의 데이터를 추출할 수 없다.
		// set에저장한 데이타를 부르는 방법
		for(Object o : set) {
			System.out.println(o);
			
		}
	
	}

}
