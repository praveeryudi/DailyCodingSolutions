package solutions.dailySolutions;

/**
 * Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length,
 * return any one.
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb".
 * The longest palindromic substring of "bananas" is "anana".
 */
public class _46_LongestPalindromicSubstring {

    private static int maxLength = 0;
    private static String output = "";

    public static void main(String[] args) {
        String str = "bananas";
        for(int i = 0; i < str.length(); i++) {
            expandFromCenter(str, i, i);
            expandFromCenter(str, i, i+1);
        }
        System.out.println("LPS = " + output);
    }

    private static void expandFromCenter(String s, int begin, int end) {
        int n = s.length();
        while(begin >= 0 && end < n && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        begin++;
        end--;
        int len = end - begin + 1;
        if(len > maxLength) {
            maxLength = len;
            output = s.substring(begin, begin + maxLength);
        }

    }


}
