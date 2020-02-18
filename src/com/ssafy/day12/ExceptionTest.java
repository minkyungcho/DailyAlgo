package com.ssafy.day12;


public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("매개변수로 받은 두개의 수!!");
			int su1 = Integer.parseInt(args[0]);			// NumberFormat, ArrayIndexOutOfBounds
			int su2 = Integer.parseInt(args[1]);			// NumberFormat, ArrayIndexOutOfBounds
			System.out.println("su1="+su1+", su2="+su2);	
			System.out.println("su1을 su2로 나눈 몫="+su1/su2);	// Arithmethic
			System.out.println("나눗셈을 잘 실행하였습니다!");
		}
		catch(Exception e) {
			System.out.println("# 모든 예외처리~ "+e.getMessage());
		}
//		catch(NumberFormatException e){
//			System.out.println("# 숫자만 입력하세요!");
//			
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("# 두개의 수를 입력하세요!");
//			
//		} catch(ArithmeticException e) {
//			System.out.println("# 0으로 나누면 안됩니다!");
//			
//		}
	}

}
