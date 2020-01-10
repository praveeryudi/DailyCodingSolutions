package dailyCodingProblem;

import java.util.Arrays;

public class _35_SegregateColors {

	public static void main(String[] args) {
		char[] colors = new char[] {'G', 'B','R', 'B', 'G', 'R'};
		
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
		System.out.println(Arrays.toString(colors));
	}

}
