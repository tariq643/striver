package dsa.striver.graphs.additionalProblems;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    /* Function to perform DFS for storing the
    nodes in stack based on their finishing time */
    private void dfs (int node, int[] visited, ArrayList<ArrayList<Integer>> adj,
                      Stack<Integer> stack) {

        visited[node] = 1;

        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, visited, adj, stack);
            }
        }
        stack.push(node);
    }

    /* Helper function to perform DFS for finding
    number of Strongly connected components */
    private void helperDFS (int node, int[] visited,
                            ArrayList<ArrayList<Integer>> adjTranspose) {

        visited[node] = 1;

        for (int it : adjTranspose.get(node)) {
            if (visited[it] == 0) {
                helperDFS(node, visited, adjTranspose);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        // call the dfs to do a topological sorting on the graph
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, stack);
            }
        }
        // to store the reversed graph
        ArrayList<ArrayList<Integer>> adjTransverse = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjTransverse.add(new ArrayList<>());
        }
    }
}
