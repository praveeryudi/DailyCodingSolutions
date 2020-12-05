package src.solutions.dailySolutions;

/**
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last.
 * You can only swap elements of the array.
 * Do this in linear time and in-place.
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class _448_SegregateColors {

    public static void main(String[] args) {
        char[] colors = {'B', 'R', 'G', 'B', 'G', 'R', 'G'};
        segregateColors(colors);
    }

    private static void segregateColors(char[] colors) {
        int low = 0, mid = 0, high = colors.length - 1;
        char temp = '\0';
        while(mid <= high) {
            switch(colors[mid]) {
                case 'R':
                    temp = colors[low];
                    colors[low] = colors[mid];
                    colors[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 'G':
                    mid++;
                    break;

                case 'B':
                    temp = colors[high];
                    colors[high] = colors[mid];
                    colors[mid] = temp;
                    high--;
                    break;
            }
        }

        System.out.println(colors);
    }

}
