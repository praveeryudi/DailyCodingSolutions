package src.solutions.google;

import java.util.Arrays;

public class _35_SegregateColors {

    public static void main(String[] args) {
        char[] colors = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};

        int n = colors.length;
        int low = 0, mid = 0, high = n-1;

        while(mid <= high) {

            char temp;
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

        System.out.println(Arrays.toString(colors));

    }


}
