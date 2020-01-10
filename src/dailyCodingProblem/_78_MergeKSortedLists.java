package dailyCodingProblem;

public class _78_MergeKSortedLists {
	
	private static class Node<T> {
		T key;
		Node next;
		
		public Node(T key) {
			this.key = key;
		}
	}
	
	private static Node merge(Node[] nodes, int start, int end) {
		if(start == end)
			return nodes[start];
		
		if(start < end) {
			int mid = (start + end)/ 2;
			Node leftNode = merge(nodes, start, mid);
			Node rightNode = merge(nodes, mid + 1, end);
			return sortedMerge(leftNode, rightNode);
		}
		return null;
	}
	
	private static Node sortedMerge(Node<Integer> n1, Node<Integer> n2) {
		if(null == n1)
			return n2;
		if(null == n2)
			return n1;
		
		Node<Integer> res;
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
	
	private static void printSortedList(Node head) {
		Node curr = head;
		while(null != curr) {
			System.out.print(curr.key + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head1 = new Node(3);
		head1.next = new Node(5);
		head1.next.next = new Node(7);
		
		Node head2 = new Node(30);
		head2.next = new Node(50);
		head2.next.next = new Node(70);
		
		Node head3 = new Node(10);
		head3.next = new Node(15);
		head3.next.next = new Node(17);
		
		Node[] nodes = new Node[] {head1, head2, head3};
		Node sortedHead = merge(nodes, 0, nodes.length - 1);
		
		//Print
		printSortedList(sortedHead);
	}

}
