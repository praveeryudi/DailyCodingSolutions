package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

public class _613_PrefixSumMap {

    private static class TrieNode {
        char data;
        Map<Character, TrieNode> children;
        int sum;
        boolean isEnd;
        TrieNode(char data) {
            this.data = data;
            this.children = new HashMap<>();
            this.sum = 0;
            this.isEnd = false;
        }
    }

    private static TrieNode root = new TrieNode('\0');

    private static void addWord(String word, int weight) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            }
            else {
                TrieNode temp = new TrieNode(ch);
                curr.children.put(ch, temp);
                curr = temp;
            }
            curr.sum += weight;
        }
        curr.isEnd = true;
    }

    private static int searchPrefix(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)) {
                return curr.sum;
            }
            else {
                curr = curr.children.get(ch);
            }
        }
        return curr.sum;
    }

    public static void main(String[] args) {
        addWord("columnar", 5);
        addWord("column", 3);
        addWord("colgate", 2);

        int res = searchPrefix("col");
        System.out.println("Weight: " + res);
        res = searchPrefix("columnar");
        System.out.println("Weight: " + res);
    }

}
