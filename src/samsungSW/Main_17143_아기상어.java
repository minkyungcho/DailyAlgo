package samsungSW;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_17143_아기상어 {
    
    ///d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
    static int moveX[] = {0,0,0,1,-1};
    static int moveY[] = {0,-1,1,0,0};
    static int R ,C, M, result=0;
    static Shark[][] shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        shark = new Shark[R+1][C+1];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            shark[r][c] = new Shark(s,d,z);
        }
        // 맨 왼쪽에서 시작
        int currentIndex = 0;
        for(int col=0; col<C; col++) {
            //시작하자마자 이동
            currentIndex++;
            for(int r=1; r<=R; r++) {
                // 현재 인덱스에서 가장 가까운 상어를 찾아서 result에 더한 후, break
                if(shark[r][currentIndex] != null) {
                    result += shark[r][currentIndex].z;
                    shark[r][currentIndex] = null;
                    break;
                }
            }
            // 상어를 큐에 넣고 이동을 위해 배열을 초기화시킨다.
            Queue<SharkMove> queue = new LinkedList<>();
            for(int i=1; i<=R; i++) 
                for(int j=1; j<=C; j++) 
                    if(shark[i][j] != null) 
                        queue.add(new SharkMove(i, j, shark[i][j].s, shark[i][j].d, shark[i][j].z));
                
            
            shark = new Shark[R+1][C+1];
            
            while(!queue.isEmpty()) {
                SharkMove sm = queue.poll();
                for(int s=0; s<sm.s; s++) {
                    /////d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
                    if(sm.d == 1 || sm.d == 2) {
                        int newY = sm.r + moveY[sm.d];
                        // 벽을 만나면 1은 2로 2는 1로 방향이 바뀐다. 이것을 처리해주기 위함 
                        if(!(1<=newY && newY<=R))
                            sm.d = 3 - sm.d;
                        sm.r += moveY[sm.d];
                    }else {
                        int newX = sm.c + moveX[sm.d];
                        // 벽을 만나면 3은 4로 4는 3로 방향이 바뀐다.
                        if(!(1<=newX && newX<=C))
                            sm.d = 7 - sm.d;
                        sm.c += moveX[sm.d];
                    }
                }
                // 만약 해당 위치에 이미 상어가 있다면 크기 비교후 큰 상어만 남긴다. 
                if(shark[sm.r][sm.c] != null) {
                    if(sm.z > shark[sm.r][sm.c].z) {
                        shark[sm.r][sm.c] = new Shark(sm.s, sm.d, sm.z);
                    }
                }else {
                    shark[sm.r][sm.c] = new Shark(sm.s, sm.d, sm.z);
                }
            }
        }
        System.out.println(result);
    }
    public static class SharkMove{
        int r;
        int c;
        int s;
        int d;
        int z;
        public SharkMove(int r,int c, int s, int d, int z) {
            this.r=r;
            this.c=c;
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
    public static class Shark{
        int s;
        int d;
        int z;
        public Shark(int s, int d, int z) {
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
}