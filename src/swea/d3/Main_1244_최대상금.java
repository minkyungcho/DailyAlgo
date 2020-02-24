package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1244_최대상금 {

	static int T;
	static int[] numarr;
	static int[] combiarr;
	static int max;
	static int num;
	static String numS;
	static int change;
	static int numl;
	static ArrayList<int[]> combilist;	
	static String swapnumS="";
	static int swapnum;
	static int[] swapnumarr;
	static int[] maxnumarr;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/swea/d3/1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			max = 0;
			st = new StringTokenizer(br.readLine(), " ");
			numS = st.nextToken();
			change = Integer.parseInt(st.nextToken());
			numl = numS.length();
			numarr = new int[numl];
			swapnumarr = new int[numl];
			maxnumarr = new int[numl];
			combiarr = new int[2];
			combilist = new ArrayList<>();

			for (int i = 0; i < numl; i++) {
				numarr[i] = numS.charAt(i)-48;
			}
			
			
			// combi
			
			for (int i = 0; i < change; i++) {
				combi(0, 0);
				swap();
				System.arraycopy(maxnumarr, 0, numarr, 0, numl);
			}
			
			
			System.out.println("#"+testcase+" "+max);
		}
	}

	private static void swap() {
		for (int i = 0; i < combilist.size(); i++) {
			swapnumS="";
			int[] tmp = combilist.get(i);
			int idx1 = tmp[0];
			int idx2 = tmp[1];
			for (int j = 0; j < numl; j++) {
				if(j==idx1) {
					swapnumarr[j] = numarr[idx2];
				}
				else if(j==idx2) {
					swapnumarr[j] = numarr[idx1];
					
				}
				else {
					swapnumarr[j] = numarr[j];
				}
			}
			for(int n : swapnumarr) {
				swapnumS += n;
			}
			int swapnum = Integer.parseInt(swapnumS);
			if(max < swapnum) {
				max = swapnum;
				System.arraycopy(swapnumarr, 0, maxnumarr, 0, numl);
			}
			
		}
		
	}

	private static void combi(int cnt, int start) {
		
		if(cnt==2) {
			combilist.add(new int[] {combiarr[0],combiarr[1]});
			return;
		}
		for (int i = start; i < numl; i++) {
			combiarr[cnt] = i;
			combi(cnt+1, i+1);
		}
		
	}

}
