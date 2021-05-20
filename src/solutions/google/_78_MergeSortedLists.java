package src.solutions.google;

import java.util.Arrays;
import java.util.List;

/**
 * Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.
 */
public class _78_MergeSortedLists {

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.next = new Node(5);
        n1.next.next = new Node(8);

        Node n2 = new Node(11);
        n2.next = new Node(13);
        n2.next.next = new Node(15);

        Node n3 = new Node(33);
        n3.next = new Node(37);
        n3.next.next = new Node(41);

        Node mergedStartNode = mergeKSortedLists(Arrays.asList(n1, n2, n3));
        while(null != mergedStartNode) {
            System.out.print(mergedStartNode.data + " ");
            mergedStartNode = mergedStartNode.next;
        }
    }

    private static Node mergeKSortedLists(List<Node> nodeList) {
        return helper(nodeList, 0, nodeList.size() - 1);
    }

    private static Node helper(List<Node> nodeList, int start, int end) {
        if(start > end) return null;
        if(start == end) return nodeList.get(start);
        int mid = start + (end - start) / 2;
        Node left = helper(nodeList, start, mid);
        Node right = helper(nodeList, mid + 1, end);
        return merge2SortedLists(left, right);
    }

    private static Node merge2SortedLists(Node n1, Node n2) {
        if(null == n1) return n2;
        if(null == n2) return n1;
        Node res;
        if(n1.data <= n2.data) {
            res = n1;
            res.next = merge2SortedLists(n1.next, n2);
        }
        else {
            res = n2;
            res.next = merge2SortedLists(n1, n2.next);
        }
        return res;
    }

}
