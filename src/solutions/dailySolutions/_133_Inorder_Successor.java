package src.solutions.dailySolutions;

public class _133_Inorder_Successor {
	
	private static class Node {
		Integer key;
		Node left;
		Node right;
		
		Node(Integer key) {
			this.key = key;
		}
	}
	
	private static Node getInorderSuccessor(Node root, Node target) {
		if(null == root || null == target)
			return null;
		
		if(null != target.right)
			return getMinimumInLeftSubtree(target.right);
		
		Node succ = null;
		while(null != root) {
			if(target.key < root.key) {
				succ = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return succ;
	}
	
	private static Node getMinimumInLeftSubtree(Node node) {
		Node prev = null;
		while(null != node) {
			prev = node;
			node = node.left;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(15);
		
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		
		root.right.left.right = new Node(14);
		Node target = root.right.left.right; 

		Node output = getInorderSuccessor(root, target);
		System.out.println("Inorder Successor = " + output.key);
	}

}
