package src.solutions.dailySolutions;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * For example, given the following array:
 * ['eat', 'ate', 'apt', 'pat', 'tea', 'now']
 * Return:
 * [['eat', 'ate', 'tea'],
 *  ['apt', 'pat'],
 *  ['now']]
 */
public class _395_Group_Anagrams {

    public static void main(String[] args) {
        List<List<String>> output = groupAnagrams(Arrays.asList("eat", "ate", "apt", "pat", "tea", "now"));
        System.out.println(output);
    }

    private static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = Arrays.toString(chars);
            List<String> value;
            if(map.containsKey(sortedWord)) {
                value = map.get(sortedWord);
                value.add(word);
                map.put(sortedWord, value);
            }
            else {
                value = new ArrayList<>();
                value.add(word);
                map.put(sortedWord, value);
            }
        }
        return new ArrayList<>(map.values());
    }
}
