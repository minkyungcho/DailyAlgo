package nds;

public class N3 {

	public static void main(String[] args) {

//		String s = "abababab";
//		String s = "abcabcabd";

		String s = "aaaa";
        
		int len = s.length();
		int answer = len;
		
        for (int i = 1; i < (len+1)/2 + 1; i++) {
        	if (len % i == 0) {
				int num = len / i;
				String str = s.substring(0,i);
				System.out.println(str);
				for (int j = 0; j < len; j+=i) {
					if(s.substring(j, j+i).equals(str)) {
						continue;
					}else {
						break;
					}
				}
        	}else {
        		answer = i;
        		break;
        	}
		}
		
        System.out.println(answer);
	}

}
