package com.ssafy.day11;

public class InterfaceTest {

	public static void main(String[] args) {
		
		MenuPan menu = new HongKong();
		// 부모				// 자식
		// Interface는 new 사용 X
		
		menu.짜장면();
		menu.짬뽕();
		// menu.초밥(); // 불가능
		
		
	}

}
