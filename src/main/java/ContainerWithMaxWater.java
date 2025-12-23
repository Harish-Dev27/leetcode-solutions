public class ContainerWithMaxWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMaxWaterSolution(height));
    }

    private static int containerWithMaxWaterSolution(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
