package top.stringNarray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P06MeetingRoom2 {

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
		
		Interval in1 = new Interval(1,4);
		Interval in2 = new Interval(4,5);
		Interval in3 = new Interval(4,6);
//		Interval in1 = new Interval(5,10);
//		Interval in2 = new Interval(15,20);
//		Interval in3 = new Interval(0,30);
		
		Interval[] intervals = {in1, in2, in3};
		
		P06MeetingRoom2 a = new P06MeetingRoom2();
		System.out.println(a.solve(intervals));
		
	}
	
	// 2. 시간범위에 있는거 minHeap 으로 poll()
	public int solve(Interval[] intervals) {
		if(intervals == null && intervals.length == 0) return 0;
		
		// start 기준  sort
		Arrays.sort(intervals, (a,b) -> (a.start-b.start));
		
		Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a,b) -> (a.end-b.end));

		int max = 0;
		for (int i = 0; i < intervals.length; i++) {
			
			while(!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start) {
				minHeap.poll(); // (15,20)
			}
			minHeap.offer(intervals[i]); // (0,30) (5,10)
			max = Math.max(max, minHeap.size());
		}
		
		return max;
	}
}
