package swea.d3;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_d3_1206_View {
     
    static int T=10;
    static int  N;
    static int[] building;
     
    public static void main(String[] args) throws Exception {
         
        //System.setIn(new FileInputStream("res/1206_View.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;
        int tmp;
        for(int testcase=1; testcase<T+1; testcase++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            building = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++) {
                building[i] = Integer.parseInt(st.nextToken());
            }
             
            for(int i=2; i<N-2; i++) {
                tmp = 0;
                int a = building[i]-building[i-1];
                int b = building[i]-building[i-2];
                int c = building[i]-building[i+1];
                int d = building[i]-building[i+2];
                if(a>0 && b>0 && c>0 && d>0) {
                    int[] arr = new int[] {a,b,c,d};
                    int min = arr[0];
                    for(int ar : arr) {
                        if(min>ar) {
                            min=ar;
                        }
                    }
                    result+=min;
                }
            }
             
            System.out.println("#"+testcase+" "+result);
        }
         
    }
 
}