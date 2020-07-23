package src.solutions;

public class _204_CountNodes {

    private static class Node<T> {
        T key;
        Node left;
        Node right;

        Node(T key){
            this.key = key;
            left = right = null;
        }
    }

    private static int getLeftBoundaryCount(Node root) {
        if(null == root)
            return 0;

        int h = 0;
        while(null != root) {
            h++;
            root = root.left;
        }
        return h;
    }

    private static int getRightBoundaryCount(Node root) {
        if(null == root)
            return 0;

        int h = 0;
        while(null != root) {
            h++;
            root = root.right;
        }
        return h;
    }

    private static int countNodes(Node root) {
        if(null == root)
            return 0;

        int leftNodes = getLeftBoundaryCount(root);
        int rightNodes = getRightBoundaryCount(root);
        if(leftNodes == rightNodes)
            return (int)Math.pow(2, leftNodes) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(13);
        root.left = new Node<>(10);
        root.right = new Node<>(14);

        root.left.left = new Node<>(15);
        root.left.right = new Node<>(20);

        int c = countNodes(root);

        System.out.println(c);

    }

}
