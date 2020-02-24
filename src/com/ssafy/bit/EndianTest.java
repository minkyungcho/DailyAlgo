package com.ssafy.bit;

public class EndianTest {

	public static void main(String[] args) {
		
		int n = 0x00111111;
		if((n & 0xff) != 0) {
			System.out.println("little endian");
		}else {
			System.out.println("big endian");
		}
		
		
	}

}
