package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all paths from the root to leaves.
 *
 * For example, given the tree:
 *
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * Return [[1, 2], [1, 3, 4], [1, 3, 5]].
 */
public class _587_RootToLeaves {

    private static List<List<Integer>> paths = new ArrayList<>();

    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static void getPaths(Node root) {
        helper(root, new ArrayList<>());
        System.out.println(paths);
    }

    private static void helper(Node root, List<Integer> current) {
        if(null == root) return;
        current.add(root.data);
        if(null == root.left && null == root.right) {
            paths.add(new ArrayList<>(current));
        }
        helper(root.left, current);
        helper(root.right, current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);
        getPaths(root);
    }

}
