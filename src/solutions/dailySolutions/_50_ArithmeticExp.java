package src.solutions.dailySolutions;

/**
 * Suppose an arithmetic expression is given as a binary tree.
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 * <p>
 * Given the root to such a tree, write a function to evaluate it.
 * <p>
 * For example, given the following tree:
 * <p>
 * *
 * / \
 * +    +
 * / \  / \
 * 3  2  4  5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */
public class _50_ArithmeticExp {

    private static class TreeNode {
        char key;
        TreeNode left;
        TreeNode right;

        TreeNode(char key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('*');
        root.left = new TreeNode('+');
        root.right = new TreeNode('+');

        root.left.left = new TreeNode('3');
        root.left.right = new TreeNode('2');
        root.right.left = new TreeNode('4');
        root.right.right = new TreeNode('5');

        int result = evaluateExpression(root);
        System.out.println(result);
    }


    private static int evaluateExpression(TreeNode root) {
        if (Character.isDigit(root.key)) {
            return Character.getNumericValue(root.key);
        }

        int leftVal = evaluateExpression(root.left);
        int rightVal = evaluateExpression(root.right);

        switch (root.key) {
            case '+':
                return leftVal + rightVal;
            case '-':
                return leftVal - rightVal;
            case '*':
                return leftVal * rightVal;
            case '/':
                return leftVal / rightVal;
            default:
                return 0;
        }
    }

}
