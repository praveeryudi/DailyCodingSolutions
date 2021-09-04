package solutions.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 *
 * Given the string "([)]" or "((()", you should return false.
 */
public class _712_BalancedParentheses {

    private static boolean isBalanced(String input) {
        if(null == input || input.isEmpty()) return true;
        if(input.startsWith(")") || input.startsWith("}") || input.startsWith("]"))
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> st = new Stack<>();

        for(char ch : input.toCharArray()) {
            if(map.containsKey(ch)) {
                st.push(ch);
            }
            else if(!st.isEmpty() && map.get(st.peek()) == ch) {
                st.pop();
            }
            else {
                return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("([])[]({})"));
    }

}
