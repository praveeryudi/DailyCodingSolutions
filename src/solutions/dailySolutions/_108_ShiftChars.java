package solutions.dailySolutions;

/**
 * Given two strings A and B, return whether or not A can be shifted some number of times to get B.
 *
 * For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
 */
public class _108_ShiftChars {

    private static boolean canShift(String a, String b) {
        if(a.length() != b.length()) return false;
        String repeatTwice = a.concat(a);
        return repeatTwice.contains(b);
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";
        System.out.println(canShift(a, b));
    }

}
