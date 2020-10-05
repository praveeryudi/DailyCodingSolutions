package src.solutions.dailySolutions;

import java.util.Stack;

public class _53_QueueWithStacks {
	
	private Stack<Integer> st1 = new Stack<Integer>();
	private Stack<Integer> st2 = new Stack<Integer>();

	public static void main(String[] args) {
		
		_53_QueueWithStacks obj = new _53_QueueWithStacks();
		obj.enqueue(10);
		obj.enqueue(8);
		obj.enqueue(7);
		
		obj.dequeue();
		obj.dequeue();
		obj.enqueue(6);
		obj.printQueue();
	}
	
	private void printQueue() {
		System.out.println(st1.toString()); 
	}
	
	private void enqueue(int item) {
		st1.push(item);
	}
	
	private int dequeue() {
		while(!st1.isEmpty()) {
			int data = st1.pop();
			st2.push(data);
		}
		
		int ele = st2.pop();
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return ele;
	}

}
