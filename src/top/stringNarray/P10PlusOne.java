package top.stringNarray;

public class P10PlusOne {

	public static void main(String[] args) {

//		int[] digits = {1,2,3};
//		int[] digits = {1,2,3};
		int[] digits = {8,9,9};
		
		int[] result = plusOne(digits);
		for(int i:result) {
			System.out.println("val: "+i);
		}

	}

	public static int[] plusOne(int[] digits) {
		
		// 1.
		
		
		// 2. for 2->1->0
		for (int i = digits.length-1; i >= 0; i--) {
			if(digits[i] != 9) {
				digits[i]++;
				break;
			}else {
				digits[i] = 0;
			}
			if(digits[i]==0) {
				int[] result = new int[digits.length+1];
				result[0] = 1;
				return result;
			}
		}
		
		return digits;
	}
}
