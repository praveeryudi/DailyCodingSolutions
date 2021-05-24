package src.solutions.google;

/**
 * Invert a binary tree.
 *
 * For example, given the following tree:
 *
 *     a
 *    / \
 *   b   c
 *  / \  /
 * d   e f
 * should become:
 *
 *   a
 *  / \
 *  c  b
 *  \  / \
 *   f e  d
 */
public class _83_InvertTree {

    private static class Node {
        char data;
        Node left;
        Node right;
        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');

        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');

        preorder(root);
        helper(root);
        System.out.println("");
        preorder(root);
    }

    private static void helper(Node root) {
        if(null == root) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }

    private static void preorder(Node root) {
        if(null == root) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

}
