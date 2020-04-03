package dailyCodingProblem;

import java.util.Stack;

public class _86_RemoveParentheses {

	public static void main(String[] args) {
		
		String input = "()())()";
		int result = minimumParenthesesToRemove(input);
		System.out.println("Output :: " + result);
	}
	
	private static int minimumParenthesesToRemove(String input) {
		
		int open = 0, closed = 0;
		Stack<Character> st = new Stack<Character>();
		for(char ch : input.toCharArray()) {
			if(ch == ')') {
				if(closed < open) {
					closed++;
					st.push(ch);
				}
			}
			else {
				open++;
				st.push(ch);
			}
		}
		
		String res = "";
		open = closed = 0;
		while(!st.isEmpty()) {
			char ch = st.pop();
			if(ch == '(') {
				if(open < closed) {
					open++;
					res = ch + res;
				}
			}
			else {
				closed++;
				res = ch + res;
			}
		}

		System.out.println("Balanced String - " + res);
		
		return input.length() - res.length();
	}

}
