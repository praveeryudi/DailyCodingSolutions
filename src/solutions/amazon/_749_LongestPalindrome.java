package solutions.amazon;

/**
 * Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.
 *
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
 */
public class _749_LongestPalindrome {

    private static int max;
    private static String lps;

    public static void main(String[] args) {
        String s = "banana";
        for(int i = 0; i < s.length(); i++) {
            expandFromCenter(s, i, i);
            expandFromCenter(s, i, i+1);
        }
        System.out.println("Longest Palindrome: " + lps);
    }

    private static void expandFromCenter(String s, int begin, int end) {
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        begin++;
        end--;

        int len = end - begin + 1;
        if(len > max) {
            max = len;
            lps = s.substring(begin, begin + len);
        }
    }

}
