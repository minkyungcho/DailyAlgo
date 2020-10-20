package top.stringNarray;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){
		this.start = 0;
		this.end = 0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}

public class P01MeetingRoom {

	public static void main(String[] args) {
		
		P01MeetingRoom a = new P01MeetingRoom();
		
//		Interval in1 = new Interval(15,20);
//		Interval in2 = new Interval(5,10);
//		Interval in3 = new Interval(0,30);
		Interval in4 = new Interval(7,10);
		Interval in5 = new Interval(2,4);
		
//		Interval[] intervals = {in1, in2, in3};
		Interval[] intervals = {in4, in5};
		
		System.out.println(a.solve(intervals));
	}

	public boolean solve(Interval[] intervals) {
		
		if(intervals == null) {
			return false;
		}
//		print(intervals); // 15 5 0
		
		// 1. sorting
		Arrays.sort(intervals, Comp);
//		System.out.println("===============");
//		print(intervals); // 0 5 15
		
		// 2. hold.end > cur.start
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i-1].end > intervals[i].start) {
				return false;
			}
		}
		
		return true;
	}
	
	Comparator<Interval> Comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// 오름차순 
			return o1.start - o2.start;
		}
		
	};
	
	public void print(Interval[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start+" "+in.end);
		}
	}
	
	

}
