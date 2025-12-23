public class SearchA2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 7, 8}, {11, 16, 17}};
        System.out.println(searchA2dMatrix(matrix, 7));
    }

    private static boolean searchA2dMatrix(int[][] matrix, int target) {
        //[[1, 2, 3],[5, 7, 8],[11, 16, 17]] t= 7 then return true

        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[0].length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
