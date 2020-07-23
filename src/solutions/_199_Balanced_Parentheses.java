package src.solutions;

/**
 * Given a string of parentheses, find the balanced string that can be produced from it
 * using the minimum number of insertions and deletions.
 * If there are multiple solutions, return any of them.
 * For example, given "(()", you could return "(())". Given "))()(", you could return "()()()()".
 */
public class _199_Balanced_Parentheses {

    public static void main(String[] args) {
        String str = "))()(";
        String output = getBalancedString(str);
        System.out.println("Balanced string = " + output);
    }

    private static String getBalancedString(String input) {
        if(null == input || input.isEmpty())
            return null;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : input.toCharArray()) {
            if(ch == '(') {
                count++;
                sb.append(ch);
            }
            else {
                if(count <=0) {
                    sb.append("(");
                }
                else {
                    count--;
                }
                sb.append(ch);
            }
        }

        while(count > 0) {
            sb.append(")");
            count--;
        }
        return sb.toString();
    }

}
