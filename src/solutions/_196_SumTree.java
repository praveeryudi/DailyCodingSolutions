package solutions;

public class _196_SumTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private void constructSumTree(TreeNode root) {
        if(null == root)
            return;
        if(null != root.left && null != root.right)
            root.val += root.left.val + root.right.val;
        if(null == root.left && null != root.right)
            root.val += root.right.val;
        if(null == root.right && null != root.left)
            root.val += root.left.val;
        constructSumTree(root.left);
        constructSumTree(root.right);
    }

}
