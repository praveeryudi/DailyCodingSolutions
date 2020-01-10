package dailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class _102_Contiguous_Sum {

	public static void main(String[] args) {
		
		int[] nums = new int[] {3,6,7,4,8,2,1};
		int k = 22;
		
		int start = 0;
		int end = -1;
		Map<Integer, Integer> map = new HashMap();
		int currentSum = 0;
		for(int index = 0; index < nums.length; index++) {
			
			currentSum += nums[index];
			if(currentSum == k) {
				start = 0;
				end = index;
			}
			
			if(map.containsKey(currentSum - k)) {
				start = map.get(currentSum -k) + 1;
				end = index;
			}
			
			map.put(currentSum, index);
		}

		if(end == -1)
			System.out.println("No contiguous element sum found !!");
		else
		System.out.println("Sum found between indices = " + start + " and " + end);
		
	}

}
