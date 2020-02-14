package baekjoon.simulation;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main_Simulation_17135_캐슬디펜스_class  {
	static int H, W, D;
	static int[] combi;		//조합 배열
	static LinkedList<Enemy> enemys=new LinkedList<Enemy>();	//적을 담을 곳
	static LinkedList<Enemy> backup=new LinkedList<Enemy>();	//제거된 적이 담길 곳
	static int max = 0;
	static int pos = -1;
	static class Enemy implements Comparable<Enemy>{
		int sr;				//적의 처음 row
		int r;				//적의 row
		int c;				//적의 col
		boolean flag;		//죽었는지 여부
		int d;				//궁수와 적의 거리 => 정렬하기 위한.
		public Enemy(int r, int c) {
			this.r = r;
			this.sr= r;
			this.c = c;
		}
		public int compareTo(Enemy o) {
			int sd=  d - o.d;
			if(sd==0) {
				return c-o.c;   //거리가 같으면 왼쪽거 정렬
			}else {
				return sd;
			}
		}
		public void init() {//조합이 바꼈을 때를 위한 초기화
			r = sr;
			flag = false;
		}
		public void move() {	//적이 성벽으로 이동
			r++;
		}
		public boolean isDead() {
			return flag;
		}
		public boolean isBounds(int cr, int cc, int d) {	//궁수 사거리 내에 있는 경우
			this.d = (Math.abs(cr-r)+Math.abs(cc-c));
			return d>= this.d;
		}
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + ", flag=" + flag + ", d=" + d + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/simulation/17135_캐슬디펜스.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		combi = new int[3];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				int data = Integer.parseInt(st.nextToken());
				if(data>0) {
					enemys.add(new Enemy(i, j));
				}
			}
			if(pos==-1 && enemys.size()>0) {  //적의 위치를 파악  N-1위치 부터 pos까지만 이동하기 위해 적의 위치를 파악한다. 
				pos = i;  
			}
		}
		combination(0,0);
		System.out.println(max);
	}
	private static void combination(int cnt, int start) {
		if(cnt == 3) {  //조합 완료
//			System.out.println(Arrays.toString(numbers));
			startGame();
			initGame();
			return;
		}
		for (int i = start; i <W; i++) {
			combi[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	private static void initGame() {  //조합이 바뀔때마다 적들을 초기화 
		for (Enemy enemy : backup) {
			enemy.init();
			enemys.add(enemy);
		}
		backup.clear();
	}
	private static void startGame() {
		LinkedList<Enemy> deathNote  = new LinkedList<>();//제거될 예정인 적들을 담을 곳
		int n =H, d=D, cnt=0;
		Enemy  e;
		for (int i = H-1; i >=pos; i--) {
			for (int c : combi) {				//궁수 쏘기
				for (Enemy enemy : enemys) {	
					if(enemy.isBounds(n, c, d)) {//사거리 내에 있으면
						deathNote.add(enemy);	 //아직 죽이면 안됨. 
					}
				}
				if(deathNote.size()>0) {
					Collections.sort(deathNote); 
					deathNote.get(0).flag=true;	 //가장 가까운 사거리 중  왼쪽꺼 제거하기로 표시  => 여기서 제거하면 다른 궁수가 딴 놈 쏠 수 있어서 그냥 둠
				}
				deathNote.clear();
			}
			//궁수가 모두 공격한 후 공격 당한 적 제거 
			for (int j = enemys.size()-1; j >=0; j--) {
				e = enemys.get(j);
				if(e.isDead()) {  //죽었으면
					backup.add(enemys.remove(j)); //살아있는 적에서 빼기 
					cnt++;						  //공격한 적 수 세기
					continue;
				}
				e.move();							//적 이동
				if(e.r == n) {						//성벽에 닿으면 제거
					backup.add(enemys.remove(j));
				}
			}
		}
		max = Math.max(max, cnt);
	}
}




