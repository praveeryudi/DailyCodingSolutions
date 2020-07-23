package src.solutions;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 */
public class _8_Unival_Trees {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private static int countUnivalTrees(Node root) {
        if(null == root) return 0;

        int left = countUnivalTrees(root.left);
        int right = countUnivalTrees(root.right);
        if(isUnival(root))
            return 1 + left + right;
        return left + right;
    }

    private static boolean isUnival(Node root) {
        if(null == root) return true;
        if(null == root.left && null == root.right)
            return true;
        if(null != root.left && root.data != root.left.data)
            return false;
        if(null != root.right && root.data != root.right.data)
            return false;
        return isUnival(root.left) && isUnival(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(2);
        root.right = new Node(1);

        root.right.left = new Node(1);
        root.right.right = new Node(1);
        root.right.right.right = new Node(1);
        System.out.println("Is univalue = " + isUnival(root));
        int univalTreesCount = countUnivalTrees(root);
        System.out.println("# of unival trees = " + univalTreesCount);
    }
}
