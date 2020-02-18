package com.ssafy.day12;

import java.io.File;
import java.io.IOException;

// 입출력 클래스 : ~InputStream, ~OutputStream, ~Reader, ~Writer
public class FileTest {
	
	public static void main(String[] args) throws IOException {
		
		// 전체경로를 명시해줘야함
//		File f = new File(String pathname);
		
		File f = new File("C:\\SSAFY\\01_java\\Algo\\res\\a.txt");
//		f = new File("a.txt"); 	// 생략된 경로(이클립스내에서 가능)
//		f = new File(".");		// .경로 : current directory(현재경로)
//		f = new File(".."); 	// ..경로 : parent directory(부모경로)
//		f = new File("../..");	// ../.. : 상위 폴더의 상위폴더
		
		
		File f2 = new File("a.txt"); 	// 생략된 경로(이클립스내에서 가능)
		f2 = new File(".."); 	// 생략된 경로(이클립스내에서 가능)
		System.out.println("f2.getPath()==>."+f2.getAbsolutePath());
		System.out.println("f2.getAbsolutePath()"+f2.getAbsolutePath());
		System.out.println("f2.getCanonicalPath()"+f2.getCanonicalPath());
		
		File f3 = new File("res/ab.txt"); 	
//		System.out.println("f3 파일(디렉토리)존재 유무 "+true.);
		
		if(f3.isFile()) {
			System.out.println();
		}
		if(f3.isDirectory()) {
			System.out.println("f3은 디렉토니(폴더)!!");
		}
		
		// 문제) song폴더에 b.txt 파일을 생성하시오.
		// 참고 : FileWriter, FileInputStream은 파일을 생성하는 기능을 갖는다.
		
		// new FileReader("b.txt");		// 없는 파일의 경우  에러 확률^
		
		// new FileWriter("b.txt");		// 없는 파일의 경우 파일생성!
		//
	}
}
