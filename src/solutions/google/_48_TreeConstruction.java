package src.solutions.google;

public class _48_TreeConstruction {

    private static class Node<Character> {
        Character data;
        Node<Character> left;
        Node<Character> right;
        Node(Character data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static int preIndex = 0;

    private static Node<Character> constructTree(char[] preOrder, char[] inOrder) {
        return helper(preOrder, inOrder, 0, preOrder.length - 1);
    }

    private static Node<Character> helper(char[] preOrder, char[] inOrder, int start, int end) {
        if(start > end) return null;
        Node<Character> root = new Node<>(preOrder[preIndex++]);
        if(start == end)
            return root;
        int i = getInorderIndex(inOrder, root.data, start, end);
        root.left = helper(preOrder, inOrder, start, i-1);
        root.right = helper(preOrder, inOrder, i + 1, end);
        return root;
    }

    private static int getInorderIndex(char[] inOrder, char key, int s, int e) {
        for(int index = s; index <= e; index++) {
            if(inOrder[index] == key)
                return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] preTraversal = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
        char[] inTraversal = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
        Node<Character> root = constructTree(preTraversal, inTraversal);
        testTree(root);
    }

    private static void testTree(Node<Character> root) {
        if(null == root) return;
        testTree(root.left);
        System.out.print(root.data + " ");
        testTree(root.right);
    }

}
