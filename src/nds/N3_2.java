package nds;

public class N3_2 {

	public static void main(String[] args) {

//		String s = "abababab";
//		String s = "abcabcabd";

		String s = "aaaa";
        
		int len = s.length();
		int answer = len;
		
		for (int i = 1; i < len; i++) {
            if (len % i != 0) continue;

             boolean flag = true;
             String tmp = s.substring(0, i);
             System.out.println(tmp);
             for (int j = 1, l = len/i; j < l; j++) {
                if (!s.substring(j*i, j*i+i).equals(tmp)) {
                   flag = false;
                   break;
                }
             }

             if (flag) answer = len / i;
        }
		
        System.out.println(answer);
	}

}
