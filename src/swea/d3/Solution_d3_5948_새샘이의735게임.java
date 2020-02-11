package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_d3_5948_새샘이의735게임 {

	static int T;
	static int[] nums;
	static int[] sums;
	static int[] picks;
	static int[] picktmp;
	static ArrayList<int[]> pickList;

	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d3/5948_새샘이의735게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<T+1; test_case++) {
			
			
			pickList = new ArrayList<int[]>();
			picks = new int[4]; // 정수 3개와 합을 저장하는 배열. 
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
			
			Collections.sort(pickList, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[3]-o2[3];
				}
				
			});
			
			// 합이 5번째로 큰 수 찾기  
			int cnt=1;
			for (int i = 300; i > 0; i--) {
				if(cnt==5) {
					result = i;
				}
				if(sums[i]!=0) {
					cnt++;
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void combination(int cnt, int startIdx) {
		
		if(cnt==3) {
			int sum=0;
			for(int p:picktmp) {
				sum+=p;
			}
			picks = new int[] {picktmp[0], picktmp[1], picktmp[2], sum};
			pickList.add(picks);
			sums[sum]=1;
			return;
		}
		
		for (int i = startIdx; i < 7; i++) {
			picktmp[cnt] = nums[i];
			combination(cnt+1, i+1);
		}
		
	}
}
