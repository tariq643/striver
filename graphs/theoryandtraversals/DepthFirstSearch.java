package dsa.striver.graphs.theoryandtraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {

    private void dfs (int node, List<List<Integer>> adj, boolean[] visited, List<Integer> dfs) {

        dfs.add(node);
        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, dfs);
            }
        }
    }

    private List<Integer> dfsOfGraph (int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        List<Integer> dfs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, dfs);
            }
        }
        return dfs;
    }

    public static void main(String[] args) {

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(2, 3, 1));
        adj.get(1).add(0);
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(0);
        adj.get(4).add(2);

        List<Integer> dfs = depthFirstSearch.dfsOfGraph(V, adj);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}
