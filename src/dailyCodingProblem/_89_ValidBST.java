package dailyCodingProblem;

public class _89_ValidBST {
	
	private static class Node<T extends Comparable> {
		T key;
		Node left;
		Node right;
		
		public Node(T key) {
			this.key = key;
			left = right = null;
		}
	}
	
	private static boolean isValidBST(Node root, Comparable min, Comparable max) {
		if(null == root)
			return true;
		
		if(root.key.compareTo(min) < 0 || root.key.compareTo(max) > 0)
			return false;
		
		return isValidBST(root.left, min, root.key) && isValidBST(root.right, root.key, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(34);
		root.left = new Node(12);
		root.right = new Node(45);
		
		root.left.left = new Node(10);
		root.left.right = new Node(15);
		
		root.right.left = new Node(36);
		root.right.right = new Node(47);
		
		boolean isValid = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println("Is Binary Tree Valid = " + isValid);
		
	}

}
