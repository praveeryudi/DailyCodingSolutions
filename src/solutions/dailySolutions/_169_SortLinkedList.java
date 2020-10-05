package src.solutions.dailySolutions;

public class _169_SortLinkedList {
	
	private static class Node {
		int key;
		Node next;
		
		public Node(int key) {
			this.key = key;
			this.next = null;
		}
	}
	
	private static Node sortedMerge(Node n1, Node n2) {
		if(null == n1)
			return n2;
		if(null == n2)
			return n1;
		
		Node res;
		if(n1.key <= n2.key) {
			res = n1;
			res.next = sortedMerge(n1.next, n2);
		}
		else {
			res = n2;
			res.next = sortedMerge(n1, n2.next);
		}
		return res;
	}
	
	private static Node getMiddleNode(Node head) {
		if(null == head)
			return head;
		
		Node slow = head, fast = head;
		while(null != fast.next && null != fast.next.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static Node sortList(Node head) {
		if(null == head || null == head.next)
			return head;
		
		Node midNode = getMiddleNode(head);
		Node midNext = midNode.next;
		midNode.next = null;
		
		Node left = sortList(head);
		Node right = sortList(midNext);
		
		return sortedMerge(left,right);
	}
	
	private static void printList(Node head) {
		while(null != head) {
			if(null == head.next) {
				System.out.print(head.key);
			}
			else {
				System.out.print(head.key + " -> ");
			}
			head = head.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head = new Node(12);
		head.next = new Node(8);
		head.next.next = new Node(23);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(17);
		
		Node newHead = sortList(head);
		printList(newHead);

	}

}