package solutions.google;

/**
 * Given the head of a singly linked list, swap every two nodes and return its head.
 *
 * For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.
 */
public class _714_Swap2Nodes {

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node swapNodes(Node head) {
        if(null == head)
            return null;
        int count = 0;
        Node curr = head;
        Node prev = null, next = null;
        while(count < 2 && null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(null != next) {
            head.next = swapNodes(next);
        }
        return prev;
    }

    public static void main(String[] args) {
        Node start = new Node(3);
        start.next = new Node(10);
        start.next.next = new Node(12);
        start.next.next.next = new Node(7);
        Node res = swapNodes(start);

        while(null != res) {
            System.out.print(res.data + "->");
            res = res.next;
        }
    }

}
