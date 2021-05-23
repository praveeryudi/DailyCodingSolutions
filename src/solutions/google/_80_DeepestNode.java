package src.solutions.google;

/**
 * Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.
 *
 *     a
 *    / \
 *   b   c
 *  /
 * d
 */
public class _80_DeepestNode {

    private static class Node {
        char key;
        Node left;
        Node right;
        Node(char key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        int depth = getDepth(root);
        Node deep = getDeepestNode(root, depth);
        System.out.println("Deepest - " + deep.key);
    }

    private static Node getDeepestNode(Node root, int level) {
        if(level == 1) return root;
        if(level > 1) {
            Node left = getDeepestNode(root.left, level - 1);
            Node right = getDeepestNode(root.right, level - 1);
            return null != left ? left : right;
        }
        return null;
    }

    private static int getDepth(Node root) {
        if(null == root) return 0;
        int lH = getDepth(root.left);
        int rH = getDepth(root.right);
        return 1 + Math.max(lH, rH);
    }
}
