package solutions.google;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 */
public class _644_UnivalTrees {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    private static int count = 0;

    private static void countUnivalTrees(Node root) {
        if(null == root) return;
        if(isUnival(root))
            count++;
        countUnivalTrees(root.left);
        countUnivalTrees(root.right);
    }

    private static boolean isUnival(Node root) {
        if(null == root) return false;
        if(null == root.left && null == root.right) return true;
        if(null != root.left && root.left.key != root.key) return false;
        if(null != root.right && root.right.key != root.key) return false;
        return isUnival(root.left) && isUnival(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);

        root.right.left = new Node(1);
        root.right.right = new Node(0);

        root.right.left.left = new Node(1);
        root.right.left.right = new Node(1);
        countUnivalTrees(root);
        System.out.println(count);
    }

}
