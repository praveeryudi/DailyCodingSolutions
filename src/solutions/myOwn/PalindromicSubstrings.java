package src.solutions.myOwn;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String str = "abccbc";

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


}
