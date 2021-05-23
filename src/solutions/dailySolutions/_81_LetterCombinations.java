package src.solutions.dailySolutions;

import java.util.*;

/**
 * Given a mapping of digits to letters (as in a phone number), and a digit string,
 * return all possible letters the number could represent.
 * You can assume each valid number in the mapping is a single digit.
 *
 * For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return
 * [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
 */
public class _81_LetterCombinations {

    private static Map<Character, List<String>> mapping;
    private static List<String> res = new ArrayList<>();

    static {
        mapping = new HashMap<>();
        mapping.put('2', Arrays.asList("a", "b", "c"));
        mapping.put('3', Arrays.asList("d", "e", "f"));
        mapping.put('4', Arrays.asList("g", "h", "i"));
        mapping.put('5', Arrays.asList("j", "k", "l"));
        mapping.put('6', Arrays.asList("m", "n", "o"));
        mapping.put('7', Arrays.asList("p", "q", "r", "s"));
        mapping.put('8', Arrays.asList("t", "u", "v"));
        mapping.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        getCombinations("23", 0, new StringBuilder());
        System.out.println(res);
    }

    // Backtracking
    private static void getCombinations(String digit, int index, StringBuilder current) {
        if(index == digit.length()) {
            res.add(current.toString());
            return;
        };
        char number = digit.charAt(index);

        for(String str : mapping.get(number)) {
            current.append(str);
            getCombinations(digit, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
