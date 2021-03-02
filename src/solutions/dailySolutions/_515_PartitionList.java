package src.solutions.dailySolutions;

/**
 * Given a linked list of numbers and a pivot k, partition the linked list so that
 * all nodes less than k come before nodes greater than or equal to k.
 *
 * For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3, the solution could be 1 -> 0 -> 5 -> 8 -> 3
 */
public class _515_PartitionList {

    private static class Node<Integer> {
        Integer key;
        Node next;
        Node(Integer key) {
            this.key = key;
            this.next = null;
        }
    }

    private static Node partitionList(Node<Integer> head, int pivot) {

        if(null == head)
            return null;

        Node lowHead = new Node<>(-1);
        Node highHead = new Node<>(-1);
        Node lowPtr = lowHead;
        Node highPtr = highHead;

        Node<Integer> curr = head;
        while(null != curr) {
            if(curr.key < pivot) {
                lowPtr.next = curr;
                lowPtr = lowPtr.next;
            }
            else {
                highPtr.next = curr;
                highPtr = highPtr.next;
            }
            curr = curr.next;
        }

        highPtr.next = null;
        lowPtr.next = highHead.next;
        return lowHead.next;
    }

    public static void main(String[] args) {
        Node start = new Node<>(14);
        start.next = new Node<>(7);
        start.next.next = new Node<>(15);
        start.next.next.next = new Node<>(6);
        start.next.next.next.next = new Node<>(2);
        Node head = partitionList(start, 10);

        // Print the list
        while(null != head) {
            System.out.print(head.key + " -> ");
            head = head.next;
        }
    }

}
