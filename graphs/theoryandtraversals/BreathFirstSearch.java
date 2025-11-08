package dsa.striver.graphs.theoryandtraversals;

import java.util.*;

public class BreathFirstSearch {

    private void bfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        
        vis[node] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            ans.add(current);

            for (int neighbour : adj.get(current)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        boolean visited[] = new boolean[V];
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                bfs(i, adj, visited, output);
            }
        }
        return output;
    }

    public static void main(String[] args) {

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

        BreathFirstSearch sol = new BreathFirstSearch();

        List<Integer> bfs = sol.bfsOfGraph(V, adj);

        System.out.println("The BFS traversal of the given graph is: " + bfs);
    }
}
