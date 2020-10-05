package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _48_TreeFromPreorderAndInorder {
	
	private class Node {
		char data;
		Node left;
		Node right;
		
		Node(char data) {
			this.data = data;
		}
	}
	
	private int preIndex = 0;
	
	private Node helper(char[] preorder, char[] inorder, int start, int end) {
		if(start > end)
			return null;
		
		Node root = new Node(preorder[preIndex]);
		preIndex++;
		int index = -1;
		for(index = start; index <= end; index++) {
			if(inorder[index] == root.data) {
				break;
			}
		}
		root.left = helper(preorder, inorder, start, index - 1);
		root.right = helper(preorder, inorder, index + 1, end);
		return root;
	}
	
	private void doInorder(Node root, List<Character> traversal) {
		if(null == root)
			return;
		doInorder(root.left, traversal);
		traversal.add(root.data);
		doInorder(root.right, traversal);
	}

	public static void main(String[] args) {

		char[] preorder = new char[] {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
		char[] inorder = new char[] {'d', 'b', 'e', 'a', 'f', 'c','g'};
		_48_TreeFromPreorderAndInorder obj = new _48_TreeFromPreorderAndInorder();
		Node treeRoot = obj.helper(preorder, inorder, 0, preorder.length - 1);
		List<Character> traversal = new ArrayList<Character>();
		obj.doInorder(treeRoot, traversal);
		
		Stream<Character> cStream = IntStream.range(0, inorder.length).mapToObj(i -> inorder[i]);
		assert traversal.equals(cStream.collect(Collectors.toList()));
		System.out.println(traversal);
	}

}
