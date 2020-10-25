package src.solutions.dailySolutions;

public class _112_LCA_Parent_Pointer {
	
	private static final class Node {
        private final int data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
	}
	
	private static int getDepth(Node node) {
		int depth = 0;
		while(null != node.parent) {
			node = node.parent;
			depth++;
		}
		return depth;
	}
	
	private static Node getLCA(Node n1, Node n2) {
		int d1 = getDepth(n1);
		int d2 = getDepth(n2);
		
		while(d1 > d2) {
			n1 = n1.parent;	
			d1--;
		}
		
		while(d2 > d1) {
			n2 = n2.parent;
			d2--;
		}
		
		while(null != n1 && null != n2) {
			if(n1 == n2)
				return n1;
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return null;
	}

	public static void main(String[] args) {

		Node four = new Node(4);
        Node six = new Node(6);
        createTree(four, six);
        System.out.println(getLCA(four, six).data);

	}
	
	 private static void createTree(Node four, Node six) {
	        Node five = new Node(5);

	        Node three = new Node(3);
	        three.left = four;
	        three.right = five;
	        four.parent = three;
	        five.parent = three;

	        Node two = new Node(2);
	        two.left = six;
	        two.right = three;
	        six.parent = two;
	        three.parent = two;

	        Node root = new Node(1);
	        root.left = two;
	        two.parent = root;
	}

}
