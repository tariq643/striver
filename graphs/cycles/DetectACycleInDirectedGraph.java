package dsa.striver.graphs.cycles;

import java.util.List;

public class DetectACycleInDirectedGraph {

    private boolean dfsCycleExists (int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int it : adj.get(node)) {
            if (pathVisited[it]) {
                return true;
            }
            else {
                if (dfsCycleExists(it, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public boolean isCyclic(int N, List<List<Integer>> adj) {

        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfsCycleExists (i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
