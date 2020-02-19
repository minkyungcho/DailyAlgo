package com.ssafy.bit;

public class EndianDecodeTest {

	static int[] intToByte(int n) {
		int[] p = new int[4];
		for (int i = 0, size = p.length; i < size; i++) {
			p[i] = ((n >> (24-i*8)) & 0xff );
		}
		return p;
	}
	
	public static void main(String[] args) {
		
		int x = 0x01020304;
		int[] p = new int[4];
		for (int i = 0, size=p.length; i < size; i++) {
			p[i] = (( x >> (i*8)) & 0xff);
		}
		System.out.printf(" x : %d %d %d %d\n", p[0], p[1], p[2], p[3]);
		p = intToByte(x);
		System.out.printf(" x : %d %d %d %d\n", p[0], p[1], p[2], p[3]);
	}

}
