package top.stringNarray;

public class P08LicenseKeyFormatting {

	public static void main(String[] args) {

		String str = "8F3Z-2e-9-wabcdef";
		int k = 4;
		System.out.println(solve(str,k));
		
	}

	public static String solve(String str, int k) {
		String newStr = str.replace("-", "");
		newStr = newStr.toUpperCase();
		
		int len = newStr.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(newStr.charAt(i));
		}
		for (int i = k; i < len; i+=k) {
			sb.insert(len-i, '-');
		}
		return newStr;
	}
}
