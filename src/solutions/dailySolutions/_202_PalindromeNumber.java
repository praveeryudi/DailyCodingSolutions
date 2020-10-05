package src.solutions.dailySolutions;

public class _202_PalindromeNumber {

    public static void main(String[] args) {
        int num = 110;
        int reversed = getReverse(num);
        if(num == reversed)
            System.out.println("Number is Palindrome");
        else
            System.out.println("Number not Palindrome");
    }

    private static int getReverse(int N) {
        int rev = 0;
        while(N > 0) {
            rev = (10 * rev) + (N % 10);
            N = N/ 10;
        }
        return rev;
    }
}
