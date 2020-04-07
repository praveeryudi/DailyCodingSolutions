package dailyCodingProblem;

public class _208_PartitionList {

	private static class ListNode {
		int key;
		ListNode next;
		public ListNode(int key) {
			this.key = key;
		}
	}
	
	private static ListNode partitionList(ListNode head, int pivot) {
		
		if(null == head || null == head.next)
			return head;
		ListNode less = new ListNode(0);
		ListNode lessHead = less;
		ListNode more = new ListNode(0);
		ListNode moreHead = more;
		
		ListNode curr = head;
		while(null != curr) {
			if(curr.key < pivot) {
				lessHead.next = curr;
				lessHead = lessHead.next;
			}
			else {
				moreHead.next = curr;
				moreHead = moreHead.next;
			}
			curr = curr.next;
		}
		
		moreHead.next = null;
		lessHead.next = more.next;
		return less.next;
	}
	
	public static void main(String[] args) {

		ListNode start = new ListNode(14);
		start.next = new ListNode(7);
		start.next.next = new ListNode(15);
		start.next.next.next = new ListNode(6);
		start.next.next.next.next = new ListNode(2);
		ListNode head = partitionList(start, 10);
		
		// Print the list
		while(null != head) {
			System.out.print(head.key + " -> ");
			head = head.next;
		}
	}

}
