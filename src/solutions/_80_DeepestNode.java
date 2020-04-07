package src.solutions;

public class _80_DeepestNode {
	
	public static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		
		public Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
	
	private static int getHeight(Node root) {
		if(null == root)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return 1 + Math.max(left, right);
	}
	
	private static Node deepestNode(Node root, int level) {
		if(null == root)
			return null;
		
		if(level == 1)
			return root;
		
		else if(level > 1) {
			Node left = deepestNode(root.left, level - 1);
			Node right = deepestNode(root.right, level - 1);
			return null != left ? left : right;
		}
		
		else
			return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.right.left = new Node(5); 
        root.right.right = new Node(6); 
        root.right.left.right = new Node(7); 
        root.right.right.right = new Node(8); 
        root.right.left.right.left = new Node(9); 
		
		int height = getHeight(root);
		Node result = deepestNode(root, height);
		System.out.println("Deepest Node Value :: " + result.data);
	}

}
