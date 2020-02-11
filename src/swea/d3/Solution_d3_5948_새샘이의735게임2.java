package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_d3_5948_새샘이의735게임2 {

	static int T;
	static int[] nums;
	static int[] sums;
	static int[] picktmp;
	static ArrayList<Pick> pickList;
	
	static class Pick implements Comparator<Pick>{
//		int[] pickNums;
		int n1;
		int n2;
		int n3;
		int pickSum;
		
		public Pick() {
		}
		public Pick(int n1, int n2, int n3, int pickSum) {
//			this.pickNums[0] = pickNums[0];
//			this.pickNums[1] = pickNums[1];
//			this.pickNums[2] = pickNums[2];
//			this.pickNums = pickNums;
			this.n1 = n1;
			this.n2 = n2;
			this.n3 = n3;
			this.pickSum = pickSum;
		}
		
		@Override
		public String toString() {
			return "Pick [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", pickSum=" + pickSum + "]";
		}
		@Override
		public int compare(Pick o1, Pick o2) {
//			System.out.println(o1.toString()+" "+o2.toString());
			return o1.pickSum-o2.pickSum;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/5948_새샘이의735게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<T+1; test_case++) {
			pickList = new ArrayList<Pick>();
			nums = new int[7];
			sums = new int[301]; // 정수는 100 이하의 수. 3 정수의 최대 합은 300. 
			picktmp = new int[3];
			int result=0;
			st = new StringTokenizer(br.readLine(), " "); 
			for (int i = 0; i < 7; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			
			combination(0, 0);
//			System.out.println("===SORT START==");
			Collections.sort(pickList, new Pick());
//			System.out.println("===SORT END==");
			
//			for(Pick p:pickList) {
//				System.out.println(p.toString());
//			}
			
			// 합이 5번째로 큰 수 찾기  
			
//			for(int i=0; i<pickList.size(); i++) {
//				int s = pickList[0].pickSum;
//			}
			
			
			System.out.println("#"+test_case+" "+result);
			return;
		}
	}



	private static void combination(int cnt, int startIdx) {
		
		if(cnt==3) {
			int sum=0;
			for(int p:picktmp) {
				sum+=p;
			}
			Pick p = new Pick(picktmp[0], picktmp[1], picktmp[2], sum);
			pickList.add(p);
//			System.out.println(p.toString());
			return;
		}else {
//			return;
		}
		
		for (int i = startIdx; i < 7; i++) {
			picktmp[cnt] = nums[i];
			combination(cnt+1, i+1);
		}
		
	}
}
