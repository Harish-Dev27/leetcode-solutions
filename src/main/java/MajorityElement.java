/***
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 1, 2, 2, 2, 2, 2};
        System.out.println(majorityElementSolution(arr));
    }

    /**
     * Moore's voting algo
     * @param nums
     * @return
     */
    private static int majorityElementSolution(int[] nums) {
        int element =0, count =0;

        for (int j : nums) {
            if (count == 0) {
                count++;
                element = j;
            } else if (j == element) {
                count++;
            } else {
                count--;
            }
        }


//        int count2 = 0;
//        for(int num: nums){
//            if(num == element) count2++;
//            if(count2 > nums.length/2) return element;
//        }

        return element;
    }
}
