package solutions.apple;

import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Given the root of a binary tree, find the most frequent subtree sum. The subtree sum of a node is the sum of all values under a node, including the node itself.
 *
 * For example, given the following tree:
 *
 *   5
 *  / \
 * 2  -5
 * Return 2 as it occurs twice: once as the left leaf, and once as the sum of 2 + 5 - 5.
 */
public class _748_SubtreeSum {

    private static class Node {
        int key;
        Node left;
        Node right;
        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(-5);

        populateNodeSum(root);
        Map<Integer, Integer> sortedByValueDesc = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                        .reversed()).collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedByValueDesc);

    }

    private static void populateNodeSum(Node root) {
        if(null == root) return;
        populateNodeSum(root.left);
        int sum = getSubtreeSum(root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        populateNodeSum(root.right);
    }

    private static int getSubtreeSum(Node root) {
        if(null == root) return 0;
        if(null == root.left && null == root.right) return root.key;
        return root.key + getSubtreeSum(root.left) + getSubtreeSum(root.right);
    }

}
