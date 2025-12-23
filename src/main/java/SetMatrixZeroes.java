import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,0,5}, {6,7,8}};
        System.out.println(Arrays.deepToString(setMatrixZeroesSolution(matrix)));
    }

    private static int[][] setMatrixZeroesSolution(int[][] matrix) {
        //col marker = matrix[0][..]
        //row marker = matrix[..][0]

        int col1 =1;
        //Mark the markers
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    //set the marker row
                    matrix[i][0] = 0;
                    //set the marker column
                    if(j != 0){
                        matrix[0][j] = 0;
                    }else{
                        col1 = 0;
                    }
                }
            }
        }

        //traverse safer cells first
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                //if column or row marker is zero, then set to zero
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //if (0,0) is 0 set the first row to 0
        if(matrix[0][0] == 0){
            for(int j=0; j<matrix[0].length; j++) matrix[0][j] = 0;
        }

        if(col1==0){
            for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }

        return matrix;
    }
}
