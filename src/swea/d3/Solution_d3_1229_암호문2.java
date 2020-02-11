package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_d3_1229_암호문2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 10;
		System.setIn(new FileInputStream("res/swea/d3/1229_암호문2.txt"));
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
				String cmd = st2.nextToken();
				if(cmd.equals("I")) {
					int idx = Integer.parseInt(st2.nextToken());
					int num = Integer.parseInt(st2.nextToken());
//					System.out.println("삽입 : "+idx+" "+num);
					for(int j=0; j<num; j++) {
						list.add(idx++, Integer.parseInt(st2.nextToken()));
					}
				}else if(cmd.equals("D")) {
					int idx = Integer.parseInt(st2.nextToken());
					int num = Integer.parseInt(st2.nextToken());
//					System.out.println("삭제 : "+idx+" "+num);
					for(int j=0; j<num; j++) {
						list.remove(idx);
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
