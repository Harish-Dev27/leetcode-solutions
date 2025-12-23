import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSubArray(arr));
    }

    /**
     * Kadane's Algorithm (Drop number if -ve sum else keep adding)
     * @param nums
     * @return
     */
    public static int findMaxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE, start = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) start = i;

            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = start;
                endIndex = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        int[] arrr = new int[endIndex - startIndex + 1];
        for (int j = 0; j < arrr.length; j++) {
            arrr[j] = nums[startIndex];
            startIndex++;
        }
        System.out.println("Arrays that has maximum sum is =>" + Arrays.toString(arrr));

        return maxSum;
    }
}
