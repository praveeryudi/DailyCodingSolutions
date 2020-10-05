package src.solutions.dailySolutions;

import java.util.LinkedList;
import java.util.Queue;

public class _117_Minimum_Sum_Level {
	
	private static class Node<Integer> {
		Integer key;
		Node left;
		Node right;
		
		public Node(Integer key) {
			this.key = key;
		}
	}
	
	private static int getMinimumSumLevel(Node root) {
		int level = 1;
		int res = -1;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int size = q.size();
			Integer sum = 0;
			while(size > 0) {
				Node<Integer> temp = q.poll();
				sum += temp.key;
				if(null != temp.left)
					q.add(temp.left);
				if(null != temp.right)
					q.add(temp.right);
				size--;
			}
			if(sum < min) {
				min = sum;
				res = level;
			}
			level++;
		}
		return res;
	}

	public static void main(String[] args) {
		
		// 1st Level
		Node root = new Node(5);
		
		// 2nd Level
		root.left = new Node(3);
		root.right = new Node(4);
		
		//3rd Level
		root.left.left = new Node(12);
		root.left.right = new Node(-8);
		root.right.right = new Node(2);
		
		//4th Level
		root.left.right.right = new Node(3);
		root.right.right.right = new Node(-1);
		
		int output = getMinimumSumLevel(root);
		System.out.println("Level with minimum sum = " + output);

	}

}
