package pro;

import java.util.ArrayList;

public class 문자열압축 {

	public static void main(String[] args) throws Exception {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		String s = br.readLine();
		String s = "a";
		int len = s.length();
		int min = Integer.MAX_VALUE;
		for (int i = len/2; i > 0; i--) {
			StringBuffer answer = new StringBuffer();
			String first = s.substring(0, i);
			int last = len % i;
			String lastStr = s.substring(len-last);
			int cnt = 1;
			
			for (int j = i; j <= len-i; j+=i) {
				String target = s	.substring(j, j+i);
//				System.out.println("f : "+first);
//				System.out.println("t : "+target);
				if(first.equals(target)) {
					cnt++;
				}else {
					if(cnt==1) {
						answer.append(first);
						first = target;
						cnt = 1;
					}else {
						answer.append(cnt+first);
						first = target;
						cnt = 1;
					}
				}
//				System.out.println(answer);
			}
			if(cnt>1) {
				answer.append(cnt+first);
			}else {
				answer.append(first);
			}
			answer.append(lastStr);
//			System.out.println("ans : "+answer);
			min = Math.min(answer.length(), min);
//			System.out.println("------------");
		}
		System.out.println(min);
	}

}
