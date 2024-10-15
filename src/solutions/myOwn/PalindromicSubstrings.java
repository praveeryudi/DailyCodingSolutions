package solutions.myOwn;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String str = "racecarannakayak";
        //backtrack(str, "");
        //System.out.println("# of palindromic substrings: " + counter);
        getAllPalindromicSubstrings(str);

        int n = str.length();
        int cnt = 0;
        boolean[][] dp = new boolean[n][n];

        for(int diag = 0; diag < n; diag++) {
            for(int i = 0, j = diag; j < n; i++, j++) {
                if(diag == 0) {
                    dp[i][j] = true;
                }
                else if(diag == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                }
                else {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j])
                    cnt++;
            }
        }
        System.out.println("# of palindromic substrings: " + cnt);
    }

    private static void getAllPalindromicSubstrings(String input) {
        List<String> res = new ArrayList<>();
        int n = input.length();
        boolean[][] dp = new boolean[n][n];
        // Search for palindromes for every length
        for(int L = 1; L <= n; L++) {
            for(int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if(i == j) {
                    dp[i][j] = true;
                } else if(j == i + 1) {
                    dp[i][j] = input.charAt(i) == input.charAt(j);
                } else {
                    if(input.charAt(i) == input.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]) {
                    res.add(input.substring(i, i + L));
                }
            }
        }
        System.out.println(res);
    }

    private static int counter = 0;

    private static void backtrack(String remString, String answer) {
        if(remString.length() == 0) {
            System.out.println(answer);
            counter++;
            return;
        }

        for(int i = 0; i < remString.length(); i++) {
            String prefix = remString.substring(0, i + 1);
            String ros = remString.substring(i + 1);
            if(isPalindrome(prefix)) {
                backtrack(ros, answer + "(" + prefix + ")");
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


}
