package top.stringNarray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P09KClosetPointsToOrigin {

	public static void main(String[] args) {
		
		P09KClosetPointsToOrigin a = new P09KClosetPointsToOrigin();
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
//		int[][] points = {{1,3},{-2,2}};
//		int k = 1;
		int[][] result = a.solve(points, k);
		a.print(result);
	}

	public int[][] solve(int[][] points, int k){
		Queue<int[]> queue = new PriorityQueue<>((o1,o2)->(o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]));
//		Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
		int[][] result = new int[k][2];
		int index = 0;
		for(int[] p:points) {
			queue.offer(p);
		}
		while(index < k) {
			result[index] = queue.poll();
			index++;
		}
		return result;
	}
	
	Comparator<int[]> Comp = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
		}
		
	};
	
	public void print(int[][] result) {
		for(int[] res:result) {
			for(int r:res) {
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
}
