package solutions.myOwn;

public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {3,7,2,1,5};
        int k = 15;

        int left = 0;

        int sum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum > k) {
                sum -= nums[left];
                left++;
            }

            if(sum == k) {
                System.out.println("Sum exists between indices " + left + "-" + right);
                break;
            }

        }

    }

}
