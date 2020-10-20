package top.stringNarray;

public class P02MoveZeros {

	public static void main(String[] args) {
		
		// 1.
		int[] nums = { 0, 3, 2, 0, 8, 5 };
		int index = 0;
		
		// 2.
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		// for문 끝나면 0이 들어갈 index를 알게됨 
		
		// 3.
		while(index < nums.length) {
			nums[index] = 0;
			index++;
		}
		
		// 4.
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}

}
