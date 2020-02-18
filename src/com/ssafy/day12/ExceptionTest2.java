package com.ssafy.day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		// 텍스트 파일(a.txt)을 읽어서 그 내용을 콘솔(모니터)에 출력
//		fr  = new FileReader(C:\SSAFY\01_java\Algo\src\com\ssafy\day12\ExceptionTest.java
//		
//		이클립스 - 
//		
		
		try {
			FileReader fr = new FileReader("res/a.txt");
//			System.out.println(fr.read());
			int i;
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println("#파일 읽기 성공 ^O^");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println(ex.toString());
			System.out.println(ex.getMessage());
			System.out.println("#파일경로를 확인하세요~");
		} catch (IOException ex){
			System.out.println("#입출력 에러가 발생했습니다~");
			
		}
		
		
	}

}
