package src.solutions.dailySolutions;

import java.util.LinkedList;
import java.util.Queue;

public class _83_InvertTree {
	
	public static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		
		public Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
	
	private static Node invertTree(Node root) {
		if(null == root)
			return null;
		helper(root);
		return root;
	}
	
	private static void helper(Node root) {
		if(null == root)
			return;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		helper(root.left);
		helper(root.right);
	}
	
	private static void levelOrder(Node root) {
		if(null == root)
			return;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			if(null != temp.left)
				q.offer(temp.left);
			if(null != temp.right)
				q.offer(temp.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(25);
		root.left = new Node(34);
		root.right = new Node(12);
		
		root.left.left = new Node(27);
		root.left.right = new Node(44);
		
		levelOrder(root);
		
		Node invertedRoot = invertTree(root);
		System.out.println("\n");
		
		levelOrder(invertedRoot);
	}

}
