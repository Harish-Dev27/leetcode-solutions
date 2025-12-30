package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListGraph {
    public static void main(String[] args) {
        int n = 3, m = 3;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        //   1------2
        //    \     |
        //      \   |
        //       \  |
        //         3

        //n + 1
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //directed means add only that direction
        //edge 1 to 2
        list.get(1).add(2);
        list.get(2).add(1);

        //edge 2 to 3
        list.get(2).add(3);
        list.get(3).add(2);

        //edge 1 to 3
        list.get(1).add(3);
        list.get(3).add(1);

        //print all the edges
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        breadthFirstSearchTraversal(3, list);
        depthFirstSearchTraversal(3, list);
    }


    private static void breadthFirstSearchTraversal(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer startingEle = queue.poll();
            bfs.add(startingEle);

            for (Integer i : adj.get(startingEle)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(bfs);
    }

    private static void depthFirstSearchTraversal(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> dfs = new ArrayList<>();

        dfsSearch(1, visited, dfs, adj);
        System.out.println(dfs);
    }

    private static void dfsSearch(int node, boolean[] visited, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj) {
        dfs.add(node);
        visited[node] = true;

        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                dfsSearch(i, visited, dfs, adj);
            }
        }
    }


}
