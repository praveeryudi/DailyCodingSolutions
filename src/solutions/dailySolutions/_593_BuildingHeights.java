package src.solutions.dailySolutions;

/**
 * You are given an array representing the heights of neighboring buildings on a city street, from east to west. The city assessor would like you to write an algorithm that returns how many of these buildings have a view of the setting sun, in order to properly value the street.
 *
 * For example, given the array [3, 7, 8, 3, 6, 1], you should return 3, since the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed view to the west.
 *
 * Can you do this using just one forward pass through the array?
 */
public class _593_BuildingHeights {

    public static void main(String[] args) {
        int[] heights = {3, 7, 8, 3, 6, 1};

        int count = 1;
        int n = heights.length;
        int maxHeight = heights[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(heights[i] >= maxHeight) {
                maxHeight = heights[i];
                count++;
            }
        }
        System.out.println("# of buildings: " + count);
    }

}
