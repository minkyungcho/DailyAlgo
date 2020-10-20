package top.stringNarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P05MergeInterval {

	static class Interval{
		int start;
		int end;
		public Interval(){
			this.start = 0;
			this.end = 0;
		}
		public Interval(int s, int e){
			this.start = s;
			this.end = e;
		}
	}
	
	public static void main(String[] args) {
		
		Interval in1 = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		
		P05MergeInterval a = new P05MergeInterval();
		List<Interval> list = a.merge(intervals);
		
		a.print(list);
	}

	public List<Interval> merge(List<Interval> intervals){
		if(intervals.isEmpty()) return intervals;

		// 1.
		List<Interval> result = new ArrayList<>();
		
//		print(intervals);
		Collections.sort(intervals, (a,b)-> a.start-b.start);
//		Collections.sort(intervals, comp);
//		print(intervals);
		
		// 2.
		Interval before = intervals.get(0); // [1,3]
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if(before.end >= current.start) {
				before.end = Math.max(before.end, current.end);
			}else {
				result.add(before);
				before = current;
			}
		}
		
		if(!result.contains(before)) {
			result.add(before);
		}
		
		return result;
		
	}
	
	Comparator comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
		
	};
	
	public void print(List<Interval> list) {
		for(Interval l:list) {
			System.out.println(l.start+" "+l.end);
		}
	}
}
