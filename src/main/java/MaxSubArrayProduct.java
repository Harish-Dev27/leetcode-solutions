public class MaxSubArrayProduct {

    public static void main(String[] args) {
        int[] arr = {-1, -2, 2, 5, 10, -6};
        System.out.println(maxSubArrayProductSolution(arr));
    }

    private static int maxSubArrayProductSolution(int[] nums) {
        int prefix = 0, suffix = 0, maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}
