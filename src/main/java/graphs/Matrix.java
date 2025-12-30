package graphs;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] adj = new int[n + 1][n + 1];

        //   1------2
        //    \     |
        //      \   |
        //       \  |
        //         3

        //directed means add only that direction
        //edge 1 to 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //edge 2 to 3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //edge 3 to 1
        adj[1][3] = 1;
        adj[3][1] = 1;

        System.out.println(Arrays.deepToString(adj));
    }
}
