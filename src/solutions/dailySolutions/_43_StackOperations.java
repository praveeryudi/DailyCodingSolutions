package src.solutions.dailySolutions;

import java.util.Stack;

public class _43_StackOperations {
	
	private Stack<Integer> main = new Stack<Integer>();
	private Stack<Integer> max = new Stack<Integer>();
	
	private void push(int data) {
		main.push(data);
		if(max.isEmpty() || max.peek() <= data)
			max.push(data);
	}
	
	private int pop() {
		int ret = main.pop();
		if(max.peek() == ret)
			max.pop();
		return ret;
	}
	
	private int getMax() {
		return max.isEmpty() ? -1 : max.peek();
	}
	

	public static void main(String[] args) {
		_43_StackOperations obj = new _43_StackOperations();
		obj.push(15);
		obj.push(12);
		obj.push(11);
		obj.push(21);
		
		System.out.println("Max " + obj.getMax());
		System.out.println("Popped " + obj.pop());
		System.out.println("Max " + obj.getMax());
	}

}
