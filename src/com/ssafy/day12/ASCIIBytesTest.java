package com.ssafy.day12;

public class ASCIIBytesTest {
	/*
		<자료형 변환>
				
						str.getBytes()			str.toCharArray()
					   <--------------			---------------->
		byte[] b={97,98,99}		String str="abc";		char[] ch={' a','b','c'};
						------------>			<----------
						new String(b);			new String(ch);

	 */
	public static void main(String[] args) {
		
		String str = "hi java stream!!";
		
		// 바이트 배열을 얻어 각 문자를 화면에 출력
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.write(b[i]);
			if(i%3==2) System.out.write('\n'); // 한줄에 3개의 문자씩 출력
		}
//		System.out.flush();
	}

}
