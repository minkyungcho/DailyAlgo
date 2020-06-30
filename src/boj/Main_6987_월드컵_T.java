package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵_T {
	
	static int[][] gameResult;
	static int valid;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine(), " ");
		
		gameResult = new int[4][18];
		for (int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 18; c++) {
				gameResult[r][c] = Integer.parseInt(st.nextToken());
			}
			valid = 0;
			dfs(0, 1, gameResult[r]);
			sb.append(valid).append(" ");
			
		}
		System.out.println(sb);
	}

	// 0 - {1,2,3,4,5}
	// 1 - {2,3,4,5}
	// 2 - {3,4,5}
	// 3 - {4,5}
	// 4 - {5}
	// teamB가 6이면 teamA 교체 
	static void dfs(int teamA, int teamB, int[] score) {
		// 상대 팀이 6을 넘어가는 경우 - 우리팀이 변경되어야..
		if(teamB == 6) {
			dfs(teamA+1, teamA+2, score);
			return;
		}
		
		// teamA 가 4보다 커지면 솔루션 실행
		if(teamA > 4) {
			for (int c = 0; c < score.length; c++) {
				// 아직 게임 결과내에 승패에 대한 내용이 남아있다면 실패.
				if(score[c]>0) {
					valid = 0;
					return;
				}
			}
			valid = 1;
			return;
		}
		
		for (int i = 0, j=2; i < 3; i++, j--) {
			if(score[teamA*3+i]>0 && score[teamB*3+j]>0) {
				score[teamA*3+i]--;
				score[teamB*3+j]--;
				dfs(teamA, teamB+1, score);
				score[teamA*3+i]++;
				score[teamB*3+j]++;
			}
		}
		
//		// teamA가 이기고 teamB가 지는 경우
//		if(score[teamA*3+0]>0 && score[teamB*3+2]>0) {
//			score[teamA*3+0]--;
//			score[teamB*3+2]--;
//			dfs(teamA, teamB+1, score);
//			score[teamA*3+0]++;
//			score[teamB*3+2]++;
//		}
//		
//		// teamA가 비기고 teamB가 비기는 경우
//		if(score[teamA*3+1]>0 && score[teamB*3+1]>0) {
//			score[teamA*3+1]--;
//			score[teamB*3+1]--;
//			dfs(teamA, teamB+1, score);
//			score[teamA*3+1]++;
//			score[teamB*3+1]++;
//		}
//		
//		// teamA가 지고 teamB가 이기는 경우
//		if(score[teamA*3+2]>0 && score[teamB*3+0]>0) {
//			score[teamA*3+2]--;
//			score[teamB*3+0]--;
//			dfs(teamA, teamB+1, score);
//			score[teamA*3+2]++;
//			score[teamB*3+0]++;
//		}
		
		
	}

}
