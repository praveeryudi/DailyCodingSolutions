package src.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _215_Vertical_Traversal {
	
	/**
	 * Inner class to represent a tree node.
	 * @author Acer
	 *
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	/*
	 * Inner Class to store the horizontal co-ordinate 
	 */
	private static class TreeCoordinate implements Comparable<TreeCoordinate> {
		
		int x;
		int value;
		
		public TreeCoordinate(int x, int value) {
			this.x = x;
			this.value = value;
		}
	
		
		@Override
		public int compareTo(TreeCoordinate t2) {
			if(this.x == t2.x) {
				return this.value;
			}
			return this.value;
		}
	}
	
	/*
	 * Helper method to construct the tree map. 	
	 */
	private static void populateMap(TreeNode root, int x, Map<Integer, List<TreeCoordinate>> map) {
		if(null == root)
			return;
		TreeCoordinate tc = new TreeCoordinate(x, root.val);
		if(map.containsKey(x)) {
			List<TreeCoordinate> res = map.get(x);
			//res.clear();
			res.add(tc);
		}
		else {
			List<TreeCoordinate> l = new ArrayList<TreeCoordinate>();
			l.add(tc);
			map.put(x, l);
		}
		populateMap(root.left, x - 1, map);
		populateMap(root.right, x + 1, map);
	}
	

	public static void main(String[] args) {

		Map<Integer, List<TreeCoordinate>> map = new TreeMap<>();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(0);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		
		populateMap(root, 0, map);
		
		List<List<Integer>> output = new ArrayList<>();
		for(List<TreeCoordinate> l : map.values()) {
			Collections.sort(l);
			List<Integer> res = new ArrayList<>();
			for(TreeCoordinate tc : l) {
				res.add(tc.value);
			}
			output.add(res);
		}
		
		System.out.println(output);
	}
}
