package src.solutions.dailySolutions;

/**
 * Given a binary tree and an integer k, return whether there exists a root-to-leaf path that sums up to k.
 * For example, given k = 18 and the following binary tree:
 *
 *     8
 *    / \
 *   4   13
 *  / \   \
 * 2   6   19
 * Return True since the path 8 -> 4 -> 6 sums to 18.
 */

public class _394_Root_To_Leaf_Sum {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(19);

        boolean res = isSum(root, 18);
        System.out.println(res);
    }

    private static boolean isSum(TreeNode root, int sum) {
        if(null == root)
            return false;
        if(isLeaf(root) && sum == root.key)
            return true;
        return isSum(root.left, sum - root.key) || isSum(root.right, sum - root.key);
    }

    private static boolean isLeaf(TreeNode node) {
        return null == node.left && null == node.right;
    }

}
