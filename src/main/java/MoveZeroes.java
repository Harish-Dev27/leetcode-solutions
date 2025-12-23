import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 6, 0, 12, 4, 5, 0, 0};
        System.out.println(Arrays.toString(moveZeroesSolution(nums)));
    }

    private static int[] moveZeroesSolution(int[] nums) {
        int position = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[position] = nums[i];
                position++;
            }
        }

        //set rest as 0's
        while (position < nums.length) {
            nums[position++] = 0;
        }

        return nums;
    }
}
