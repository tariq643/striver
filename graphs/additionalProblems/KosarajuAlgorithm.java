package dsa.striver.graphs.additionalProblems;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    private void dfs(int node, int[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     Stack<Integer> st) {

        // Mark the node as visited
        vis[node] = 1;

        // Traverse all its neighbors
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                // Recursively perform DFS if not visited already
                dfs(it, vis, adj, st);
            }
        }

        // Push the node in stack
        st.push(node);
    }

    /* Helper function to perform DFS for finding
    number of Strongly connected components */
    private void helperDFS(int node, int[] vis,
                           ArrayList<ArrayList<Integer>> adjT) {
        // Mark the node as visited
        vis[node] = 1;

        // Traverse all its neighbors
        for (int it : adjT.get(node)) {
            if (vis[it] == 0) {
                // Recursively perform DFS if not already visited
                helperDFS(it, vis, adjT);
            }
        }
    }

    /* Funtion call to find the number of
    strongly connected components */
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // Visited array
        int[] vis = new int[V];

        // Stack data structure
        Stack<Integer> st = new Stack<>();

        /* Perform initial DFS to store the nodes
        in stack based on their finishing time */
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // To store the reversed graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        /* Reverse all the edges of original
        graph to the reversed graph */
        for (int i = 0; i < V; i++) {
            // Mark the node as unvisited
            vis[i] = 0;

            // Add the reversed edge
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        /* To store the count of strongly
        connected components */
        int count = 0;

        /* Start DFS call from every unvisited
        node based on their finishing time */
        while (!st.isEmpty()) {
            // Get the node
            int node = st.pop();

            // If not visited already
            if (vis[node] == 0) {
                count += 1;
                helperDFS(node, vis, adjT);
            }
        }

        // Return the result
        return count;
    }
}
