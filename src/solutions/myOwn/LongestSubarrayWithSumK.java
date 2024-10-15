package solutions.myOwn;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        int left = 0, right = 0, sum = 0, n = nums.length;
        int maxLen = 0;

        while(right < n) {
            sum += nums[right];
            while(sum > k) {
                sum -= nums[left];
                left++;
            }
            if(sum == k) {
                System.out.println("Sum found between indices " + left + " and " + right);
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        System.out.println("Length of longest aubarray = " + maxLen);

        // Length of longest subarray having exactly 'k' odd numbers
        nums = new int[] { 3, -1, 3, 7, -5 };
        k = 3;
        left = 0; right = 0; maxLen = 0;
        int count = 0;
        while(right < nums.length) {
            int num = nums[right];
            if(num % 2 != 0) {
                count++;
            }
            while(count > k) {
                count --;
                left++;
            }
            if(count == k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right ++;
        }
        System.out.println("Length having exactly k odd numbers = " + maxLen);

        // Kadane Algo
        /*nums = new int[] { 10, -2, 0, 4, -7 };
        int curr_sum = nums[0], max = nums[0];
        for(int idx = 1; idx < nums.length; idx++) {
            curr_sum = Math.max(curr_sum + nums[idx], nums[idx]);
            max = Math.max(max, curr_sum);
        }
        System.out.println("Max sum is = " + max);*/
    }

}
