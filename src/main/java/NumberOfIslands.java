/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

public class NumberOfIslands {
    //Time complexity = O(m*n) and Space complexity = O(m*n)
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numberOfIslands(grid));
        System.out.println(numberOfIslands(new char[5][5]));
    }

    public static int numberOfIslands(char[][] grid) {
        //sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        //traverse through all cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0'; //mark as visited

        //traverse in all possible directions
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
