package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, return the first recurring character in it, or null if there is no recurring character.
 * For example, given the string "acbbac", return "b". Given the string "abcdef", return null.
 */
public class _159_First_Recurring_Character {
    public static void main(String[] args) {
        String input = "acbbac";

        Set<Character> seen = new HashSet<>();
        for(char ch : input.toCharArray()) {
            if(seen.contains(ch))
            {
                System.out.println("First Recurring Character = " + ch);
                break;
            }
            seen.add(ch);
        }
    }
}
