package com.ssafy.day11;

class NestingClass{		//외부 클래스 (Outer class)
	int i = 11;
	void hello() {
		System.out.println("안녕~!");
	}
	
	class NestedClass{	//내부 클래스 (Inner class)
		int j = 22;
		void print() {
			System.out.println("프린트~!");
		}
		void callTest() {	// 외부클래스 자원 사용
			hello();
			System.out.println("i="+i);
		}
	}
}

public class NestedClassTest {

	public static void main(String[] args) {

		// 외부클래스 - int i, hello(), 내부클래스
		// 내부클래스 - int j, print()
		
		NestingClass nesting = new NestingClass();
		nesting.hello();  // 외부클랴스의 메소드 호출
//		nesting.print();
		System.out.println("===================================");
		
		// 내부클래스의 메소드를  main( )에서 직접호출! --> 보통 외부클래스에서 내부클래스 호출!
		// 객체생성 : 외부클래스명, 내부클래스명   참조변수명=.new 외부생성자(), 내부클래스
		
		
	}

}
