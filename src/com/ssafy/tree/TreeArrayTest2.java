package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeArrayTest2 {
	
	static int[] tree;		// 트리 배열
	static int[] temp;		// 데이터를 입력 받을 배열
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/lecture/tree2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// index를 이용해서 자식노드를 순회하기 때문에 0번은 사용할 수 없다. 1 ~ N번까지 사용
		// 왼쪽자식 : index*2		오른쪽자식 : index*2+1
		tree = new int[N+1];
		temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// Arrays.fill을 통해 -1로 배열 채울 수 있음!
		
		for (int i = 1; i <=N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		// 1. sorting
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		
		// 2. 	트리 구성하기
		// 2.1 	index, start(1), end(N)  중앙값 찾기 (start+end)>>1
		// 2.2 	배열의 index번째에 중앙값을 저장
		// 2.3 	왼쪽 자식 : index*2, start, mid
		// 2.4	오른쪽 자식 : index*2+1, mid+1, end
		
		insert(1, 1, N);
		System.out.println(Arrays.toString(tree));
		
		
		// 중위 순회
		System.out.println("중위 순휘 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		inorder(1);
		System.out.println();
		
		// 전위 순회
		System.out.println("전위 순휘 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		preorder(1);
		System.out.println();
		
		// 후위 순회
		System.out.println("후위 순휘 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		postorder(1);
		System.out.println();
		
	}
	
	
	/**
	 * 2. 	트리 구성하기
	 * @param index
	 * @param start
	 * @param end
	 */
	public static void insert(int index, int start, int end) {
		
		if(index<=N && start<=end) {
			// 2.1 	index, start(1), end(N)  중앙값 찾기 (start+end)>>1
			int mid = (start+end)>>1;
			if(temp[mid]!=0) {
				// 2.2 	배열의 index번째에 중앙값을 저장
				tree[index] = temp[mid];
				temp[mid] = 0;
				// 2.3 	왼쪽 자식 : index*2, start, mid
				insert(index<<1, start, mid);
				// 2.4	오른쪽 자식 : index*2+1, mid+1, end
				insert((index<<1)+1, mid+1, end);
				
			}
		}
	}
	
	
	/**
	 * 트리를 중위(LVR)로 순회하는 함수
	 * @param index	 : vertex(현재 방문한 노드)의 index
	 */
	public static void inorder(int index) {
		
		// index가 N보다 작거나 같을때까지만 순회함
		// vertex가 경계 내에 있고, data가 있다.
		if(index<N+1 && tree[index]!=0) {
			// 왼쪽 자식 방문 	: vertex의 index*2
			inorder(index<<1); // index*2
			// vertex(현재 노드) 처리	
			System.out.print(tree[index]+" ");
			// 오른쪽 자식 방문	: vertex의 index*2+1
			inorder((index<<1)+1); // index*2+1 
		}
	}
	
	/**
	 * 트리를 전위(VLR)로 순회하는 함수
	 * @param index
	 */
	public static void preorder(int index) {
		
		// vertex가 경계 내에 있고, data가 있다.
		if(index<N+1 && tree[index]!=0) {
			// vertex(현재 노드) 처리	
			System.out.print(tree[index]+" ");
			// 왼쪽 자식 방문 	: vertex의 index*2
			preorder(index<<1); // index*2
			// 오른쪽 자식 방문	: vertex의 index*2+1
			preorder((index<<1)+1); // index*2+1 
		}

	}

	/**
	 * 트리를 후위(LRV)로 순회하는 함수
	 * @param index
	 */
	public static void postorder(int index) {
		
		// vertex가 경계 내에 있고, data가 있다.
		if(index<N+1 && tree[index]!=0) {
			// 왼쪽 자식 방문 	: vertex의 index*2
			postorder(index<<1); // index*2
			// 오른쪽 자식 방문	: vertex의 index*2+1
			postorder((index<<1)+1); // index*2+1 
			// vertex(현재 노드) 처리	
			System.out.print(tree[index]+" ");
		}
		
	}
	
}
