package dsa.striver.graphs.cycles;

import java.util.List;
import java.util.Stack;

public class TopologicalSortingDFSPractise {

    private void dfsOfGraph(int node, Stack<Integer> stack, boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfsOfGraph(neighbour, stack, visited, adj);
            }
        }
        stack.push(node);
    }

    public int[] topoSort(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        int[] ans = new int[V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsOfGraph(i, stack, visited, adj);
            }
        }
        for (int i = 0; i < V; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
