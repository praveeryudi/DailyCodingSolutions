package src.solutions.linkedin;

/**
 * Determine whether a tree is a valid binary search tree.
 *
 * A binary search tree is a tree with two children, left and right,
 * and satisfies the constraint that the key in the left child
 * must be less than or equal to the root and the key in the right child
 * must be greater than or equal to the root.
 */
public class _89_ValidBST {

    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean isValidBST(Node root, Integer min, Integer max) {
        if(null == root) return true;
        if(null != min && root.data <= min) return false;
        if(null != max && root.data >= max) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(34);
        root.left = new Node(12);
        root.right = new Node(45);

        root.left.left = new Node(10);
        root.left.right = new Node(15);

        root.right.left = new Node(36);
        root.right.right = new Node(47);

        boolean isValid = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("Is BST = " + isValid);
    }

}
