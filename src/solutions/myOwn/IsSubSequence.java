package src.solutions.myOwn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSubSequence {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"lo", "eo"});
        System.out.println(result);
    }

    private static List<String> wordSubsets(String[] A, String[] B) {

        result.addAll(Arrays.asList(A));

        for(String b : B) {
            for(String a : A) {
                boolean isValid = isSubsequence(b, a);
                if(!isValid) {
                    result.remove(a);
                }
            }
        }
        return result;
    }

    private static boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
            return true;
        int index = 0;
        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(index) == t.charAt(i)) {
                index++;
            }
            if(index >= s.length())
                return true;
        }
        return false;
    }
}
