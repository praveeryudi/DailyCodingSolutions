package dailyCodingProblem;

public class _26_RemoveNthNode {
	
	private static class Node<T> {
		T key;
		Node next;
		
		public Node(T key) {
			this.key = key;
			this.next = null;
		}
	}
	
	private static Node removeNthNode(Node head, int n) {
		if(null == head || null == head.next)
			return head;
		
		Node fastPtr = head, slowPtr = head;
		for(int index = 0; index < n; index++) {
			fastPtr = fastPtr.next;
		}
		
		if(null == fastPtr) {
			head = head.next;
			return head;
		}
		
		while(null != fastPtr.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		Node temp = slowPtr.next;
		slowPtr.next = temp.next;
		temp.next = null;
		
		return head;
	}
	
	private static void printList(Node head) {
		Node curr = head;
		while(null != curr) {
			System.out.print(curr.key + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node start = new Node(10);
		start.next = new Node(20);
		start.next.next = new Node(30);
		start.next.next.next = new Node(40);
		
		printList(start);
		Node startNode = removeNthNode(start, 2);
		System.out.println();
		printList(startNode);
		
	}

}
