package src.solutions.dailySolutions;


public class _296_SortedArray_To_BST {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private static TreeNode convert(int[] arr, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end)/ 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = convert(arr, start, mid - 1);
        root.right = convert(arr, mid + 1, end);
        return root;
    }

    private static void doInorder(TreeNode root) {
        if(null == root) return;
        doInorder(root.left);
        System.out.print(root.key + " ");
        doInorder(root.right);
    }

    public static void main(String[] args) {
        int[] input = {3, 12, 15, 18, 21, 22, 28};
        TreeNode node = convert(input, 0, input.length - 1);
        // Verification
        doInorder(node);
    }

}
