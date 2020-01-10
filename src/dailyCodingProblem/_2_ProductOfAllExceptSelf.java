package dailyCodingProblem;

import java.util.Arrays;

public class _2_ProductOfAllExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {3, 2, 1};
		int[] productArr = getProductArr(nums);
		System.out.println(Arrays.toString(productArr));
	}
	
	public static int[] getProductArr(int[] arr) {
        int[] productArr = new int[arr.length];
        int num = 1;

        for (int i = 0; i < arr.length; i++) {
            productArr[i] = num;
            num = num * arr[i];
        }

        num = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            productArr[i] = productArr[i] * num;
            num = num * arr[i];
        }

        return productArr;
}

}
