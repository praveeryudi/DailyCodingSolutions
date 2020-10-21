package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * If there are multiple possible solutions, return any of them.
 *
 * For example, given the string tweet, return tteew. eettw would also be acceptable.
 */
public class _386_Sort_String {

    public static void main(String[] args) {
        String input = "tweet";
        System.out.println(sortString(input));
    }

    private static String sortString(String input) {
        Map<Character, Integer> count = new HashMap<>();
        for(char ch : input.toCharArray()) {
            if(count.containsKey(ch)) {
                count.put(ch, 1 + count.get(ch));
            }
            else {
                count.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(count.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        StringBuilder output = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : entries) {
            for(int k = 0; k < entry.getValue(); k++) {
                output.append(entry.getKey());
            }
        }
        return output.toString();
    }

}
