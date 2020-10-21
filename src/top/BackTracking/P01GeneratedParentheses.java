package top.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class P01GeneratedParentheses {
	public static void main(String[] args) {
	
		P01GeneratedParentheses a = new P01GeneratedParentheses();
		System.out.println(a.generatePerenthesis_dfs(3));
		
	}
	
	public List<String> generatePerenthesis_dfs(int n){
		List<String> result = new ArrayList<>();
		dfs(result, "", n, n, "");
		return result;
	}
	
	int count ;
	
	public void dfs(List<String> result, String str, int left, int right, String str1) {
		count++;
		System.out.println("str\t"+str+"\t left: "+left+" right: "+right+" count: "+count+" str1: "+str1);
		// 1.
		if(left<0 | left>right){
			return ;
		}
		
		// 2.
		if(left==0 && right==0) {
			result.add(str);
			return ;
		}
		
		dfs(result, str+'(', left-1, right, str1+"+");
		dfs(result, str+')', left, right-1, str1+"-");
		
	}
}
