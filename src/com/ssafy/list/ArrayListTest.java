package com.ssafy.list;

import java.util.ArrayList;

/**
 *	List
 *	- 데이터를 순차적으로 유지
 *	- 새로운 데이터를 추가할 수 있는 위티는 0 ~ size()번째까지 저장할 수 있다.
 *	  저장 범위를 벗어나서 추가하면 IndexOutOfBoundsException이 발생한다.
 *
 *	ArrayList
 *	- 배열로 List를 구현
 *	- 중간 삽입이나 삭제가 많으면 데이터 이동시간이 오래 걸리므로 성능이 낮아짐.
 *	- 기본생성자로 생성하면 0개짜리 배열이 할당되서 데이터 추가시 배열의 length의 반이 증가.
 *		=> 초기 size를 지정하는 것이 좋다.
 *	
 *	indexOf(Object o), lastIndexOf(Object o), contains(Object o), remove(Object o)
 *	기능을 위해 데이터 검사시 equals(~)를 호출한다.
 *	=> 함수들의 기능을 사용하려면 저장 객테에 equals(~) 구현되어 있어야 한다.
 *
 */

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("hello");	// 맨 마지막에 추가
		list.add("hello");
		list.add("java");
		list.add("world");
		System.out.println(list);
		// indexOf(Object o) : List의 맨 앞부터 객체가 저장된 위치를 찾아서 리턴. 못찾은 경우 -1을 리턴.
		System.out.println(list.indexOf("hello"));
		// lastIndexOf(Object o) : List의 맨 뒤부터 객체가 저장된 위치를 찾아서 리턴. 못찾은 경우 -1을 리턴.
		System.out.println(list.lastIndexOf("hello"));
		// contains(~) : 동일한 데이터가 저장되어 있으면 true, 없으면 false.
		System.out.println(list.contains("world"));
		
		// add(int idx, Object) : 지정한 위치에 데이터를 추가 => 저장할 수 있는 index는 0 ~ size()
//		list.add(5, "ssafy"); // IndexOutOfBoundsException error 발생
		list.add(0, "ssafy");
		System.out.println(list);

		// get(int index) : index번째 데이터를 추출, 없으면 null
		System.out.println(list.get(0));
//		System.out.println(list.get(6)); // IndexOutOfBoundsException error 발생
		
		// remove(int index) : index번째 데이터를 삭제 
		// remove(Object data) : data 위치의  
		System.out.println(list.remove(0));
		System.out.println(list.remove("hello"));
		System.out.println(list);
	
	}

}
