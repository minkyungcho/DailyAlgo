package com.ssafy.tree;

public class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode() {}
	public TreeNode(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		if(left!=null) {
			sb.append(left.toString());
		}
		sb.append(" "+data);
		if(right!=null){
			sb.append(right.toString());
		}
		return sb.toString();
	}
	
}
