package top.stringNarray;

import java.util.HashMap;
import java.util.Map;

public class P03TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		
		P03TwoSum a = new P03TwoSum();
		
		int[] result = a.solve(nums, target);
		
		for(int i:result) {
			System.out.println(i);
		}
	}
	
	public int[] solve(int[] nums, int target) {
		// 2.
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		// 3.
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int mapValue = map.get(nums[i]); // i=1 일때 8, map(8,0)
				result = new int[]{mapValue+1, i+1};
			}else {
				map.put(target-nums[i], i); // key: 10-2=8, value: i=0 => (8,0)
			}
		}
		
		return result;
	}

}
