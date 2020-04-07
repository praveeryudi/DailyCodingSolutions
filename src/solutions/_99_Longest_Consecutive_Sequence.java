package src.solutions;

import java.util.HashMap;
import java.util.Map;

public class _99_Longest_Consecutive_Sequence {
	
	private static class Node<T> {
		T key;
		Node<T> next;
		
		public Node(T key) {
			this.key = key;
			next = null;
		}
	}

	
	public static void main(String[] args) {
		
		int[] nums = new int[] {9,1,4,7,3,-1,0,5,8,-1,6};
		Map<Integer, Node<Integer>> map = new HashMap<Integer, Node<Integer>>();
		for(int i : nums) {
			if(map.containsKey(i))
				continue;
			
			Node curr = new Node(i);
			map.put(i, curr);
			Node prev = map.get(i-1);
			Node next = map.get(i+1);
			if(null != prev)
				prev.next = curr;
			
			curr.next = next;
		}
		
		int count = 1;
		for(Node<Integer> n : map.values()) {
			count = Math.max(count, getListLength(n));
		}
		
		System.out.println("Max Length Sequence = " + count);
	}
	
	private static int getListLength(Node head) {
        int cnt = 0;
        while(null != head)
        {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

}
