package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.List;

public class _110_Root_To_Leaves {
	
	private static class Node {
		int key;
		Node left;
		Node right;
		
		Node(int key) {
			this.key = key;
		}
	}
	
	private static List<List<Integer>> results = new ArrayList<List<Integer>>();
	
	private static boolean isLeaf(Node node) {
		return null == node.left && null == node.right;
	}
	
	private static void rootToLeafPaths(Node root, List<Integer> path) {
		if(null == root)
			return;
		
		path.add(root.key);
		if(isLeaf(root)) {
			results.add(new ArrayList<Integer>(path));
		}
		
		rootToLeafPaths(root.left, path);
		rootToLeafPaths(root.right, path);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		
		Node root = new Node(13);
		root.left = new Node(10);
		root.right = new Node(14);
		
		root.left.right = new Node(15);
		root.right.left = new Node(20);
		
		rootToLeafPaths(root, new ArrayList<Integer>());
		
		System.out.println(results);

	}

}
