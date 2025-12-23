public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 0, 2};
        System.out.println(findMinInRotSortArr(arr));
        System.out.println(findMinInRotSortArr(arr2));
    }

    /**
     * Find the sorted side and pick min and eliminate whole side and proceed in same way
     * @param nums
     * @return
     */
    private static int findMinInRotSortArr(int[] nums) {
        //[5, 1, 2, 3, 4] => 1  [3, 4, 5, 1, 2] => 1

        int left = 0, right = nums.length - 1, min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }

        return min;
    }
}
