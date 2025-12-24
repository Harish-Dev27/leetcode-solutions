public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] mountain = {0, 1, 2, 1, 0};
        int[] mountain2 = {0, 10, 5, 2};
        System.out.println(peakIndexMountainArray(mountain2));
        System.out.println(peakIndexMountainArray(mountain));
    }

    private static int peakIndexMountainArray(int[] nums) {
        //[0, 1, 2, 1, 0] ans => 2
        //[0, 1, 2, 1, 3, 1, 0]

        int left = 0, right = nums.length - 1, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }


        return ans;
    }
}
