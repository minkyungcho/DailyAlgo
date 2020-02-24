package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main_1370_회의실배정_Greedy {
	
	static class Room implements Comparable<Room>{
		int no;
		int start;
		int end;
		public Room(int no, int start, int end) {
			this.no = no;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Room o) {
			// 오름차순 정렬
			int t = end - o.end;
			if(t==0) {
				t = start - o.start;
			}
			return t;
		}
		@Override
		public String toString() {
			return "Room [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
		
	}
	
	static int N;
	static Room[] rooms;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/jungol/bank/1370_회의실배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		rooms = new Room[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			rooms[i] = new Room(idx, start, end);
		}
		Arrays.sort(rooms);
//		for(Room r : rooms) {
//			System.out.println(r.toString());
//		}
		
		int num = 1;
		int etime = rooms[0].end;
		LinkedList<Integer> nums = new LinkedList<>();
		nums.add(rooms[0].no);
		for (int i = 1, size=rooms.length; i < size; i++) {
			if(etime <= rooms[i].start) {
				num++;
				etime = rooms[i].end;
				nums.add(rooms[i].no);
			}
		}
		
		System.out.println(num);
		for(int n : nums) {
			System.out.print(n+" ");
		}
		
		
	}


}
