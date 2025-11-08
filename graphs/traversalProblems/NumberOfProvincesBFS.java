package dsa.striver.graphs.traversalProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvincesBFS {

    private void bfsOnGraph (int node, boolean[] visited,
                             List<List<Integer>> adjacencyList) {

        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {

            int current = queue.poll();
            for (int neightbour : adjacencyList.get(current)) {

                if (!visited[neightbour]) {
                    queue.add(neightbour);
                    visited[neightbour] = true;
                }
            }
        }
    }

    public int numProvinces(int[][] adj) {

        int numberOfProvinces = 0;

        // calculating the number of vertices
        int V = adj.length;

        // converting adjacency matrix to list
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // wrong code

//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < V; j++) {
//
//                adjacencyList.get(i).add(j);
//                adjacencyList.get(j).add(i);
//            }
//        }

        // perform the bfs tranversal on the list
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                numberOfProvinces++;
                bfsOnGraph (i, visited, adjacencyList);
            }
        }

        return numberOfProvinces;
    }

    public static void main(String[] args) {

        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        /* Creating an instance of
        Solution class */
        NumberOfProvincesBFS sol = new NumberOfProvincesBFS();

        /* Function call to find the
        provinces in the given graph */
        int ans = sol.numProvinces(adj);

        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
