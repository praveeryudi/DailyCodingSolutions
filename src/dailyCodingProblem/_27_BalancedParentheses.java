package dailyCodingProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _27_BalancedParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "([{})]";
		System.out.println("Is Valid = " + isBalanced(str));

	}
	
	private static boolean isBalanced(String input) {
		if(null == input || input.isEmpty())
			return true;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> st = new Stack<Character>();
		for(char ch : input.toCharArray()) {
			if(map.containsKey(ch))
				st.push(ch);
			else if(!st.isEmpty() && ch == map.get(st.peek()))
				st.pop();
			else if(st.isEmpty() && map.containsValue(ch)) {
				return false;
			}
			else
				return false;
		}
		return st.isEmpty();
	}

}
