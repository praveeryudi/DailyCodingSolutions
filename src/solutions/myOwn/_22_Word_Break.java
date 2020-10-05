package src.solutions.myOwn;

import java.util.*;

/**
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction,
 * return any of them. If there is no possible reconstruction, then return null.
 *
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 *
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class _22_Word_Break {

    private static void getWords(String word, Set<String> dict) {
        boolean[] dp = new boolean[1 + word.length()];
        dp[0] = true;
        for(int lo = 0; lo < word.length(); lo++) {
            if(!dp[lo])
                continue;
            for(int hi = 1 + lo; hi <= word.length(); hi++) {
                String sub = word.substring(lo, hi);
                if(dict.contains(sub))
                    dp[hi] = true;
            }
        }
        System.out.println(Arrays.toString(dp));
        List<String> words = new ArrayList<>();
        int startIndex = 0;

        for(int index = 1; index < dp.length ; index++) {
            if(dp[index]) {
                words.add(word.substring(startIndex, index));
                startIndex = index;
            }
        }
        System.out.println(words);
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("bed", "bath", "bedbath", "and", "beyond"));
        getWords("bedbathandbeyond", dict);
    }
}
