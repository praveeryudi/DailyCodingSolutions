package src.solutions.dailySolutions;

import java.util.LinkedList;
import java.util.Queue;

public class _422_Merge2BT {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    private static Node merge2Trees(Node n1, Node n2) {
        if(null == n1 && null == n2)
            return null;
        if(null == n1) return n2;
        if(null == n2) return n1;
        Node temp = new Node(n1.key + n2.key);
        temp.left = merge2Trees(n1.left, n2.left);
        temp.right = merge2Trees(n1.right, n2.right);
        return temp;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.left.left = new Node(5);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.right.right = new Node(7);

        Node res = merge2Trees(root1, root2);
        doLevelOrder(res);
    }

    private static void doLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node t = q.poll();
                System.out.print(t + " ");
                if(null != t.left)
                    q.add(t.left);
                if(null != t.right)
                    q.add(t.right);
                size--;
            }
            System.out.println("\n");
        }
    }
}
