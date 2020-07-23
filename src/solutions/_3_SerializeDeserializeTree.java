package src.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _3_SerializeDeserializeTree {

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		_3_SerializeDeserializeTree obj = new _3_SerializeDeserializeTree();
		// Construct a test tree
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(1);
		
		String serializedTree = obj.serializeTree(root);
		Node newRoot = obj.deserializeTree(serializedTree);
		obj.doPreorder(newRoot);
	}
	
	private String serializeTree(Node root) {
		if(null == root)
			return "#";
		
		String leftStr = serializeTree(root.left);
		String rightStr = serializeTree(root.right);
		return root.data + "," + leftStr + "," + rightStr;
	}
	
	private Node deserializeTree(String input) {
		String[] arr = input.split(",");
		Queue<String> q = new LinkedList<String>();
		q.addAll(Arrays.asList(arr));
		return deserializeHelper(q);
	}
	
	private Node deserializeHelper(Queue<String> queue) {
		String str = queue.poll();
		if(str.equals("#"))
			return null;
		
		Node root = new Node(Integer.valueOf(str));
		root.left = deserializeHelper(queue);
		root.right = deserializeHelper(queue);
		return root;
	}
	
	private void doPreorder(Node root) {
		if(null == root)
			return;
		System.out.println(root.data);
		doPreorder(root.left);
		doPreorder(root.right);
	}

}
