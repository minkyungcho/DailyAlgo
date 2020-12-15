package samsungSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {

	static int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}}; // 좌 하 우 상 
	static int[][] map;
	static int out;
	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
		StringTokenizer st; // = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tornado(0,0,1,0,N/2,N/2);
		
		System.out.println(out);
	}


	private static void tornado(int corner, int count, int size, int direction, int x, int y) {
		if(x==0 && y==0) {
			return;
		}
		int nx = x + dir[direction][0];
		int ny = y + dir[direction][1];
		
		wind(x, y, nx, ny, direction);
		count++;
		
		if(count == size) {
			corner++;
			direction++;
			direction %= 4;
			count = 0;
		}
		
		if(corner == 2) {
			corner = 0;
			size++;
		}
		
		tornado(corner, count, size, direction, nx, ny);
	}


	private static void wind(int x, int y, int nx, int ny, int direction) {
		int now = map[nx][ny];
		
		int s1 = (int) (now*0.01);
		int s2 = (int) (now*0.02);
		int s5 = (int) (now*0.05);
		int s7 = (int) (now*0.07);
		int s10 = (int) (now*0.1);
		int a = now - 2*(s1+s2+s7+s10) - s5;
		
		map[nx][ny] = 0;
		
		if(direction==0 || direction==2) {
			// 1%
			for (int i = 0; i < 2; i++) {
				int sx = x + dir[1+2*i][0];
				int sy = y + dir[1+2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s1;
				}else {
					out += s1;
				}
			}
			// 2%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[1+2*i][0]*2;
				int sy = ny + dir[1+2*i][1]*2;
				if(isIn(sx, sy)) {
					map[sx][sy] += s2;
				}else {
					out += s2;
				}
			}
			// 7%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[1+2*i][0];
				int sy = ny + dir[1+2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s7;
				}else {
					out += s7;
				}
			}
			// 10%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[direction][0] + dir[1+2*i][0];
				int sy = ny + dir[direction][1] + dir[1+2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s10;
				}else {
					out += s10;
				}
			}
			// 5%
			int sx = nx + dir[direction][0]*2;
			int sy = ny + dir[direction][1]*2;
			if(isIn(sx, sy)) {
				map[sx][sy] += s5;
			}else {
				out += s5;
			}
			// a
			sx = nx + dir[direction][0];
			sy = ny + dir[direction][1];
			if(isIn(sx, sy)) {
				map[sx][sy] += a;
			}else {
				out += a;
			}
		}else {
			// 1%
			for (int i = 0; i < 2; i++) {
				int sx = x + dir[2*i][0];
				int sy = y + dir[2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s1;
				}else {
					out += s1;
				}
			}
			// 2%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[2*i][0]*2;
				int sy = ny + dir[2*i][1]*2;
				if(isIn(sx, sy)) {
					map[sx][sy] += s2;
				}else {
					out += s2;
				}
			}
			// 7%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[2*i][0];
				int sy = ny + dir[2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s7;
				}else {
					out += s7;
				}
			}
			// 10%
			for (int i = 0; i < 2; i++) {
				int sx = nx + dir[direction][0] + dir[2*i][0];
				int sy = ny + dir[direction][1] + dir[2*i][1];
				if(isIn(sx, sy)) {
					map[sx][sy] += s10;
				}else {
					out += s10;
				}
			}
			// 5%
			int sx = nx + dir[direction][0]*2;
			int sy = ny + dir[direction][1]*2;
			if(isIn(sx, sy)) {
				map[sx][sy] += s5;
			}else {
				out += s5;
			}
			// a
			sx = nx + dir[direction][0];
			sy = ny + dir[direction][1];
			if(isIn(sx, sy)) {
				map[sx][sy] += a;
			}else {
				out += a;
			}
		}
	}


	private static boolean isIn(int sx, int sy) {
		return 0<=sx && sx<N && 0<=sy && sy<N;
	}

}
