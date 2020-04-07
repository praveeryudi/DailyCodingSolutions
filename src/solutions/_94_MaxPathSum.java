package src.solutions;

public class _94_MaxPathSum {
	
	private static class Node<T> {
		T key;
		Node left;
		Node right;
		
		public Node(T key) {
			this.key = key;
		}
	}
	
	private static int result = Integer.MIN_VALUE;
	
	private static int getMaxSum(Node<Integer> root) {
		if(null == root)
			return 0;
		
		int leftSum = getMaxSum(root.left);
		int rightSum = getMaxSum(root.right);
		
		int singleMax = Math.max(root.key, Math.max(root.key + leftSum, root.key + rightSum));
		result = Math.max(result, Math.max(singleMax, root.key + leftSum + rightSum));
		return singleMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(-10);
		root.left = new Node(9);
		root.right = new Node(20);
		
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		
		getMaxSum(root);
		System.out.println("Max Sum = " + result);

	}

}
