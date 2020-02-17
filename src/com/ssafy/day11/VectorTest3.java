package com.ssafy.day11;

import java.util.Vector;

public class VectorTest3 {

	public static void main(String[] args) {
		
		// Vector에 데이터 추가, 검색, 수정, 삭제하기
		Vector<String> v = new Vector<>();
		
		// CRUD --> Create(추가), Read(검색, 조회), Update(수정), Delete(삭제)
		
		// 데이터 추가
		v.add("자바");
		v.add("SQL");
		v.add("HTML");
		v.add("JavaScript");
		v.add("JSP");
		v.add("자바");
		
		// 데이터 삭제
//		v.remove(int index);
//		v.remove(Object o);
		v.remove(0);	// 0번 인덱스 데이터를 삭제!
//		v.remove("자바");// "자바" 데이터를 삭제!
		
		// 데이터 수정
//		v.set(int index, Object element); // element : 변경(대체)할 데이터
		// 문제) 5번째 데이터 "자바"를 "자바프로그래밍"으로 변경하시오.
		v.set(4, "자바프로그래밍");
		
		// 데이터 조회
		System.out.println("다섯번째 데이터 : "+v.get(4));
		
		// for(  ; 벡터명.size();  )
		
		// 전체 데이터 조회
		for(int i=0; i<v.size(); i++) {
			String str = v.get(i);
			System.out.println(i+":"+str);
		}
		System.out.println("=========================");
		// 인덱스가 필요 없음! ---> for~each문 (개선된 for문)
		for(String s : v) {
			System.out.println(s);
		}
	}

}
