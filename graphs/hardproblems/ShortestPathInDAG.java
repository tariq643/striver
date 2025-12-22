package dsa.striver.graphs.hardproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {

    // Pair implementation
    static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void topoSort (int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        // traverse all the neighbor
        for (Pair pair : adj.get(node)) {
            int v = pair.first;
            if (!visited[v]) {
                topoSort(v, adj, visited, stack);
            }
        }
        stack.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        // create the adj list
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // add the edges and weights of the graph
        for (int i = 0; i < M; i++) {

            int u = edges[i][0]; // source node
            int v = edges[i][1]; // destination node
            int edgeWeight = edges[i][2]; // weight

            // add the weighted edge
            adj.get(u).add(new Pair(v, edgeWeight));
        }

        // do a topological sorting on the graph
        boolean[] visited = new boolean[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);

        distance[0] = 0;

        while (!stack.isEmpty()) {

            int node = stack.pop();
            for (Pair pair : adj.get(node)) {
                int v = pair.first;
                int weight = pair.second;
                if (distance[node] + weight < distance[v]) {
                    distance[v] = distance[node] + weight;
                }
            }
        }

         /* If a node is unreachable,
        updating its distance to -1 */
        for (int i = 0; i < N; i++) {
            if (distance[i] == (int)1e9)
                distance[i] = -1;
        }

        return distance;
    }
}
