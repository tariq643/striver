package dsa.striver.graphs.cycles;

import java.util.*;

public class DetectAcycleInUndirectedGraph {

    private boolean isCycleExists (int node, boolean[] visited, List<Integer>[] adj) {

        visited[node] = true;

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[]{node, -1});

        while (!bfsQueue.isEmpty()) {

                    int[] currentElement = bfsQueue.poll();
                    int visitedNode = currentElement[0];
                    int parent = currentElement[1];

                    for (int neighbour : adj[visitedNode]) {
                        if (!visited[neighbour]) {
                            bfsQueue.add(new int[]{neighbour, visitedNode});
                            visited[neighbour] = true;
                        }
                        else if (neighbour != parent) {
                            return true;
                        }
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];
        boolean ans = false;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                ans = isCycleExists(i, visited, adj);
            }
            if (ans) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        // Creating an instance of Solution class
        DetectAcycleInUndirectedGraph sol = new DetectAcycleInUndirectedGraph();

        // Function call to detect cycle in given graph.
        boolean ans = sol.isCycle(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}
