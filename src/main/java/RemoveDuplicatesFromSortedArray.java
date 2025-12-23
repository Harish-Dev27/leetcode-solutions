public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 3, 4, 5};
        System.out.println(removeDupFrmSortedArr(arr));
    }

    private static int removeDupFrmSortedArr(int[] nums) {
        //arr = [0, 1, 1, 2, 3, 3, 4, 5] => [0, 1, 2, 3, 4, 5, 3, 4, 5]
        //ans = 6

        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }

        return left + 1;
    }
}
