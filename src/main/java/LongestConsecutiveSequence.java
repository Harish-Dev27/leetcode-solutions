import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsSeqSolution(nums));
    }

    private static int longestConsSeqSolution(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int x = num;
                while (set.contains(num + 1)) {
                    count++;
                    x += 1;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
