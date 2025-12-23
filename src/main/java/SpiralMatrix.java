import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println(spiralMatrixSolution(matrix));
    }

    private static List<Integer> spiralMatrixSolution(int[][] matrix) {
        int colBegin = 0, colEnd = matrix[0].length - 1;
        int rowBegin = 0, rowEnd = matrix.length - 1;
        List<Integer> list = new ArrayList<>();

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                //traverse left
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                //traverse up
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return list;
    }
}
