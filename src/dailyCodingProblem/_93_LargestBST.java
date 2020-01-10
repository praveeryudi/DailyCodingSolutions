package dailyCodingProblem;

public class _93_LargestBST {
	
	private static class Node<T> {
		T key;
		Node left;
		Node right;
		
		public Node(T key) {
			this.key = key;
		}
	}
	
	private static int size(Node root) {
		if(null == root)
			return 0;
		
		if(null == root.left && null == root.right)
			return 1;
		
		return size(root.left) + 1 + size(root.right); 
	}
	
	private static boolean isValidBST(Node<Integer> root, int min, int max) {
		if(null == root)
			return true;
		
		if(root.key <= min || root.key >= max)
			return false;
		
		return isValidBST(root.left, min, root.key) && isValidBST(root.right, root.key, max);
	}
	
	private static int getMaxBSTSize(Node<Integer> root) {
		if(null == root)
			return 0;
		if(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return size(root);
		}
		return Math.max(getMaxBSTSize(root.left), getMaxBSTSize(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		int max = getMaxBSTSize(root);
		System.out.println("Maximum Size BST = " + max);
	}

}
