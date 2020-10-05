package src.solutions.dailySolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.
 */
public class _125_Sum_Of_Nodes {

    private static class Node {
        Integer key;
        Node left;
        Node right;

        Node(Integer key) {
            this.key = key;
        }
    }

    private static int[] getSumPair(Node root, int sum) {
        if (root == null) {
            return null;
        }
        int[] pair = new int[2];
        Set<Integer> set = new HashSet<>();
        findPair(root, set, sum, pair);
        return pair;
    }

    private static boolean findPair(Node root, Set<Integer> set, int sum, int[] pair) {
        if(null == root)
            return false;
        if(findPair(root.left, set, sum, pair))
            return true;

        if(set.contains(sum - root.key)) {
            pair[0] = root.key;
            pair[1] = sum - root.key;
            return true;
        }
        else {
            set.add(root.key);
        }
        return findPair(root.right, set, sum, pair);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.right.left = new Node(11);
        root.right.right = new Node(15);

        int[] result = getSumPair(root, 20);
        System.out.println(Arrays.toString(result));
    }

}
