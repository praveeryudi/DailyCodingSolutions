package solutions.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, return the first recurring character in it, or null if there is no recurring character.
 *
 * For example, given the string "acbbac", return "b". Given the string "abcdef", return null.
 */
public class _649_FirstRecurringChar {

    private static Character getFirstRecurringCharacter(String input) {
        Set<Character> seen = new HashSet<>();
        for(char ch : input.toCharArray()) {
            if(seen.contains(ch)) {
                return ch;
            }
            seen.add(ch);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getFirstRecurringCharacter("acbbac"));
    }

}
