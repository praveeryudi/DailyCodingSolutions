package src.solutions.dailySolutions;

import java.util.Stack;

/**
 * Given the root to a binary search tree, find the second largest node in the tree.
 */
public class _36_SecondLargestNode {

    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static int count = 0;
    private static Node secondLargest = null;

    private static void getSecondLargest(Node root) {
        if(null == root)
            return;

        getSecondLargest(root.right);
        count++;
        if(count == 2)
        {
            secondLargest = root;
            return;
        }
        getSecondLargest(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(-20);
        root.right = new Node(15);
        getSecondLargest(root);
        System.out.println("2nd Largest: " + secondLargest.data);
    }
}
