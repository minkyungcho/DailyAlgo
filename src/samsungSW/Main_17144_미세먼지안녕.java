package samsungSW;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
    public static int R, C, T;
    public static int[][] maps;
    public static int[][] spr;
    
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static Point[] M;
    public static void main(String[] args) throws Exception {
        INIT();
        for(int i = 0; i<T; i++) {
        Spread();
        Refresh();
        }
        System.out.println(TSum());
    }
    public static void INIT() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 6<= R, C <= 50
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // 1<=T <= 1000 T초가 지난 후 방에 남아있는 미세먼지의 양을 구해라
        T = Integer.parseInt(st.nextToken());
        
        maps = new int[R][C];
        M = new Point[2];
        for(int i = 0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<C; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == -1) {
                    if(M[0] == null) {
                        M[0] = new Point(i, j);
                    }else {
                        M[1] = new Point(i, j);
                    }
                }
            }
        }
    }
    //1초동안 미세먼지 확산
    public static void Spread() {
        spr = new int[R][C];        //매번 spread되는 거 저장
        int cnt = 0;
        int mul = 0;
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(maps[i][j] > 0) {
                    cnt = FineMove(i, j);        //네 방향으로 미세먼지 확산
                    mul = (maps[i][j]/5)*cnt;
                    maps[i][j] -= mul;    //확산된 방향 미세먼지 빼줌
                }
            }
        }//포문 끝
        
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                maps[i][j] += spr[i][j];    //확산된 양 총 더해줌
                //System.out.print(maps[i][j] + " ");
            }
            //System.out.println();
        }
    }
    
    //각 칸마다 미세먼지 확산 시켜줌
    public static int FineMove(int r, int c) {
        int cnt = 0;
        for(int d = 0; d<dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            //범위 안에 있고, 공기청정기가 아니면
            if(isIn(nr, nc) && maps[nr][nc]!= -1) {
                cnt++;
                spr[nr][nc] += (maps[r][c]/5);
            }
        }
        return cnt;
    }
    
    public static void Refresh() {
        //공청기1
        //아래
        for(int i = M[0].x-1; i>0; i--) {
            maps[i][0] = maps[i-1][0];
        }
        //왼쪽
        for(int j = 0; j<C-1; j++) {
            maps[0][j] = maps[0][j+1];
        }
        //위쪽
        for(int i = 0; i<M[0].x; i++) {
            maps[i][C-1] = maps[i+1][C-1];
        }
        //오른쪽
        for(int j = C-1; j>0; j--) {
            maps[M[0].x][j] = maps[M[0].x][j-1];
        }
        maps[M[0].x][1] = 0;
        
        //공청기2
        //위
        for(int i = M[1].x+1; i<R-1; i++) {
            maps[i][0] = maps[i+1][0];
        }
        
        //왼쪽
        for(int j = 0; j<C-1; j++) {
            maps[R-1][j] = maps[R-1][j+1];
        }
        //아래
        for(int i = R-1; i>M[1].x; i--) {
            maps[i][C-1] = maps[i-1][C-1];
        }
        //오른쪽
        for(int j = C-1; j>0; j--) {
            maps[M[1].x][j] = maps[M[1].x][j-1];
        }
        maps[M[1].x][1] = 0;

        
    }
    
    public static int TSum() {
        int sum = 0;
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(maps[i][j] != -1) {
                    sum += maps[i][j];
                }
            }
        }
        return sum;
    }
    public static boolean isIn(int r, int c) {
        return (0<=r && r<R && 0<=c && c<C);
    }
}