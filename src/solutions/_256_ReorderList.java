package src.solutions;

/**
 * Given a linked list, rearrange the node values such that they appear in alternating low -> high -> low -> high ... form.
 * For example, given 1 -> 2 -> 3 -> 4 -> 5, you should return 1 -> 5 -> 2 -> 4 -> 3.
 */
public class _256_ReorderList {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        reorder(head);

        while(null != head) {
            System.out.print(head.key + " -> ");
            head = head.next;
        }
    }

    private static void reorder(Node head) {

        if(null == head || null == head.next)
            return;

        Node first = head;
        Node mid = getMid(head);
        Node second = mid.next;
        mid.next = null;
        second = reverse(second);

        while(null != second) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null, next = null;
        while(null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
