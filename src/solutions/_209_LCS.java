package src.solutions;

import java.util.Arrays;

public class _209_LCS {

    private static void constructLCSMatrix(String str1, String str2, int m, int n) {
        int[][] lcs = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                else
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
            }
        }

        // Print the lcs matrix
        for(int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(lcs[i][j] + " ");
            }
            System.out.println(" ");
        }

        int index = lcs[m][n];
        int temp = index;
        char chars[] = new char[index + 1];
        chars[index] = '\0';
        int i = m, j = n;
        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                chars[index - 1] = str1.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if(lcs[i-1][j] > lcs[i][j-1])
                i--;
            else
                j--;
        }

        // Print the LCS
        for(int k = 0; k <= temp; k++) {
            System.out.print(chars[k] + " ");
        }

        String commonLCS = Arrays.toString(chars);
    }

    public static void main(String[] args) {
        String str1 = "epidemiologist";
        String str2 = "refrigeration";
        constructLCSMatrix(str1, str2, str1.length(), str2.length());
    }

}
