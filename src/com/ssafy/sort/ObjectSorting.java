package com.ssafy.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Pos implements Comparable<Pos>{
	int r, c;
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
	@Override
	public int compareTo(Pos o) {
		
		// row 값만으로 정렬
//		return r - o.r;		// 오름차순 정렬

		// r값이 같은 경우 c값으로 정렬
		int gap = r-o.r;
		if(gap==0) {
			gap = c-o.c;
		}
		return gap;
	}
	@Override
	public String toString() {
		return "Pos [r=" + r + ", c=" + c + "]";
	}
}


public class ObjectSorting {

	public static void main(String[] args) {
		
		LinkedList<Pos> list = new LinkedList<>();
		list.add(new Pos(3,5));
		list.add(new Pos(1,3));
		list.add(new Pos(1,2));
		list.add(new Pos(5,1));
		list.add(new Pos(3,2));
		
		System.out.println(list);
		Collections.sort(list);	// 클래스에 선언된 Comparable로 정렬
		
		// sort 할 때 정렬 기준을 Comparator로 제공
		Collections.sort(list, new Comparator<Pos>() {

			@Override
			public int compare(Pos o1, Pos o2) {
				// 오름차순 : o1-o2		내림차순 : o2-o1
				int gap = o2.r - o1.r;
				if(gap==0) {
					gap = o2.c - o1.c;
				}
				return gap;
			}
		});
		System.out.println(list);	
	}

}
