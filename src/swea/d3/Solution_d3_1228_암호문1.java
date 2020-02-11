package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Solution_d3_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 10;
		System.setIn(new FileInputStream("res/swea/d3/1228_암호문I.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<>();
		for(int test_case=1; test_case<T+1; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int cmdNum = Integer.parseInt(br.readLine());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<cmdNum; i++) {
				if(st2.nextToken().equals("I")) {
					int idx = Integer.parseInt(st2.nextToken());
					int num = Integer.parseInt(st2.nextToken());
					for(int j=0; j<num; j++) {
						list.add(idx++, Integer.parseInt(st2.nextToken()));
					}
				}
				
			}
			
			System.out.print("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			list.clear();
		}
			
	}

}
