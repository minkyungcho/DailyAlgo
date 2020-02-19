package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2247_도서관_Greedy {
	
	static class Study implements Comparable<Study>{
		int start;
		int end;
		public Study(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Study o) {
			// 오름차순 정렬
			int t = start-o.start;
			if(t==0) {
				t = end - o.end;
			}
			return t;
		}
		@Override
		public String toString() {
			return "Study [start=" + start + ", end=" + end + "]";
		}
	}
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/jungol/bank/2247_도서관.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Study[] studies = new Study[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			studies[i] = new Study(s, e);
		}
		
		Arrays.sort(studies);
		int oncntMax=0;
		int oncnt=0;
		int offcntMax=0;
		int offcnt=0;
		int start= studies[0].start;
		int end= studies[0].end;
		for (int i = 1; i <N; i++) {
			if(studies[i].start > end) {
				offcnt = studies[i].start - end;
				if(offcnt>offcntMax) {
					offcntMax = offcnt;
				}
				start = studies[i].start;
				end = studies[i].end;
			}else {
				if(end < studies[i].end) {
					end = studies[i].end;
				}
				oncnt = end-start;
				if(oncnt>oncntMax) {
					oncntMax = oncnt;
				}
			}
		
		}
		
		System.out.println(oncntMax+" "+offcntMax);
	}

}
