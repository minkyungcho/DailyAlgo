package com.ssafy.day11;

import java.util.Vector;

class G{
	void hello() {
		System.out.println("G클래스 안녕~!");
	}
}

public class VectorTest2 {
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		// 데이터 입력  ==> addElement(데이터); add(데이터);
		v.add("안녕");	// 인덱스 0부여
		v.add(new G());	// 인덱스 1부여
		
		// 데이터 읽기(조회) ==> get(int index)
		// 문제) 벡터 v에 저장된 G클래스의 hello()메소드를 호출하시오.
		Object ob = v.get(1);
//		ob.hello(); 	// error --> why? 부모 참조변수 통해 자식 호출 불가능.
		G g = (G) ob; 	// 자식 클래스 캐스팅 필요!
		g.hello();
		
		
		/**
		 * 	<> : 제네릭 타입 ---> 어떤 자료형을 사용할 지를 명시(명료성을 높임) : JDK5버전부터\
		 * 	
		 * 	<E> : element(요소)가 어떤 자료형을 사용할 지 명시
		 * 	<K> : key 가 어떤 자료형을 사용할 지 명시
		 * 	<V> : value 가 어떤 자료형을 사용할 지 명시
		 * 	<T> : type 가 어떤 자료형을 사용할 지 명시
		 */
//		Vector<String> v2 = new Vector<String>();
		Vector<String> v2 = new Vector<>(); // JDK7버전부터 생성자<> 빈괄호 지원
		
		v2.add("홍길동");
//		v2.add(new G()); // error : 제네릭 사용시 명시한 String 자료형만 입력할 수 있음
		
		Vector<G> v3 = new Vector<>();
		v3.add(new G());
		G obj = new G();
		v3.add(obj);
		
		System.out.println("===========");
		
		// 문제) 벡터 v3에 두번째로 저장된 G클래스의 hello()메소드를 호출하시오.
		
		G g2 = v3.get(1);
		g2.hello(); // 추가적인 캐스팅이 필요 없음.
		
		
		
		
		
		
		
		
	}
}
