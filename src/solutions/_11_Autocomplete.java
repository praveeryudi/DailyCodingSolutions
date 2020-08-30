package src.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
 * return all strings in the set that have s as a prefix.
 *
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 */

/**
 * O(W x L) Time complexity
 * O(L) Space complexity
 * W is number of words in the list and L is the length of the word
 */
public class _11_Autocomplete {

    private static class TrieNode {
        char ch;
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode(char ch) {
            this.ch = ch;
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private TrieNode root;

    private _11_Autocomplete() {
        this.root = new TrieNode('\0');
    }

    private void addWord(String word) {
        if(null == word || word.isEmpty())
            return;
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {

            if(curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            }
            else {
                TrieNode temp = new TrieNode(ch);
                curr.children.put(ch, temp);
                curr = temp;
            }

        }
        curr.isEnd = true;
    }

    private List<String> getAllPrefixStrings(String prefix) {
        TrieNode curr = root;
        int i = 0;
        while(i < prefix.length()) {
            char ch = prefix.charAt(i);
            if(curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            }
            else
                break;
            i++;
        }

        // Print all children for current node
        List<List<Character>> res = new ArrayList<>();
        traverse(curr, new ArrayList<>(), res);
        List<String> output = new ArrayList<>();
        for(List<Character> l : res) {
            String match = prefix;
            for(char c : l) {
                match = match.concat(String.valueOf(c));
            }
            output.add(match);
        }
        return output;
    }

    private void traverse(TrieNode start, List<Character> current, List<List<Character>> res) {
        if(null == start)
            return;
        if(start.isEnd)
            res.add(new ArrayList<>(current));
        for(char i = 'a'; i <= 'z'; i++) {
            current.add(i);
            traverse(start.children.get(i), current, res);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        _11_Autocomplete autocomplete = new _11_Autocomplete();
        autocomplete.addWord("dog");
        autocomplete.addWord("deer");
        autocomplete.addWord("deal");

        autocomplete.addWord("cog");
        autocomplete.addWord("cognitive");
        autocomplete.addWord("cognizant");

        List<String> allMatches = autocomplete.getAllPrefixStrings("d");
        for(String word : allMatches) {
            System.out.println(word);
        }

        allMatches = autocomplete.getAllPrefixStrings("cogni");
        for(String word : allMatches) {
            System.out.println(word);
        }
    }

}
