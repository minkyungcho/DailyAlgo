package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TreeLinked{
	TreeNode root;
	public void makeTree(int d1, int d2) {
		
		// 처음 트리를 구성할 때는 root가 없다. => root부터 생성
		if(root==null) {
			root = new TreeNode(d1);
		}
		makeTree(root, d1, d2);
		
	}
	
	private void makeTree(TreeNode root, int d1, int d2) {

		if(root!=null) {	// 재귀를 타기 때문에 root를 검사한다.
			if(root.data==d1) {
				TreeNode node = new TreeNode(d2);
				if(root.left==null) {
					root.left = node;
				}else if(root.right==null) {
					root.right = node;
				}
				return;
			}
			// d1은 root가 아니므로 root의 자손으로 d1이 있는지 찾아본다.
			makeTree(root.left, d1, d2);
			makeTree(root.right, d1, d2);
			
		}
		
	}

	public void inorder(TreeNode node) {
		
		if(node!=null) {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
		
	}

	public void preorder(TreeNode node) {
		
		if(node!=null) {
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
		
	}
	
	public void postorder(TreeNode node) {
		
		if(node!=null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+" ");
		}
		
	}
}


public class TreeLinkedTest {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/lecture/tree3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeLinked tl = new TreeLinked();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N-1; i++) { 
			tl.makeTree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		System.out.println(tl.root);
		tl.inorder(tl.root);
		System.out.println();
		tl.preorder(tl.root);
		System.out.println();
		tl.postorder(tl.root);
		System.out.println();
		
	}	
	

}
