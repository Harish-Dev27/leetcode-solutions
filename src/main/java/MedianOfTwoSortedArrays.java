public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(medianOfTwoSortedArrays(arr1, arr2));
    }

    private static double medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        //nums1 = [1,2], nums2 = [3,4] ans => 2.5
        int n = arr1.length;
        int m = arr2.length;
        if (n > m) return medianOfTwoSortedArrays(arr2, arr1);
        int left = 0, right = n;
        int elementsOnLeft = (n + m + 1) / 2;
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = elementsOnLeft - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n) r1 = arr1[mid1];
            if (mid2 < m) r2 = arr2[mid2];
            if (mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            //actual median evaluation
            if (l1 < r2 && l2 < r1) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return 0;
    }
}
