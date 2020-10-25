package src.solutions.dailySolutions;

/**
 * Given a tree, find the largest tree/subtree that is a BST.
 *
 * Given a tree, return the size of the largest tree/subtree that is a BST.
 */
public class _405_Largest_BST {

    private static int max = 0;

    private static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private static int countNodes(Node root) {
        if(null == root)  return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static boolean isBST(Node node, Integer min, Integer max) {
        if(null == node) return true;
        if(null != min && node.val <= min)
            return false;
        if(null != max && node.val >= max)
            return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    private static int getMaxBST(Node root) {
        if(null == root)
            return 0;
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            max = Math.max(max, countNodes(root));
        }
        int leftCount = getMaxBST(root.left);
        int rightCount = getMaxBST(root.right);
        return Math.max(max, Math.max(leftCount, rightCount));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);

        int res = getMaxBST(root);
        System.out.println(res);
    }

}
