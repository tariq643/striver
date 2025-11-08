package dsa.striver.graphs.traversalProblems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvincesDFS {

    private void dfsOfGraph (int node, boolean[] visited, List<Integer> dfs, List<Integer>[] adjancencyList) {

        visited[node] = true;
        dfs.add(node);

        for (int neighbour : adjancencyList[node]) {
            if (!visited[neighbour]) {
                dfsOfGraph(neighbour, visited, dfs, adjancencyList);
            }
        }
    }

    public int numProvinces(int[][] adj) {

        int V = adj.length;
        List<Integer>[] adjancencyList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjancencyList[i] = new ArrayList<>();
        }

        // converting adjancency matrix to adjancency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjancencyList[i].add(j);
                    adjancencyList[j].add(i);
                }
            }
        }

        // now the problem is similar to connected component (here we will use dfs)
        int numOfProvinces = 0;
        boolean[] visited = new boolean[V];
        List<Integer> dfs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                numOfProvinces++;
                dfsOfGraph(i, visited, dfs, adjancencyList);
            }
        }
        return numOfProvinces;
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
        NumberOfProvincesDFS sol = new NumberOfProvincesDFS();

        /* Function call to find the
        provinces in the given graph */
        int ans = sol.numProvinces(adj);

        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
