package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9093_단어뒤집기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
        	StringBuilder sb = new StringBuilder();
        	String[] strArr = br.readLine().split(" ");
        	int len = strArr.length;
        	for (int j = 0; j < len; j++) {
        		StringBuffer sbf = new StringBuffer(strArr[j]);
				sb.append(sbf.reverse()+" ");
			}
        	System.out.println(sb);
		}
	}

}
