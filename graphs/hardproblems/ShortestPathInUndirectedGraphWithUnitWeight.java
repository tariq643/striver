package dsa.striver.graphs.hardproblems;

import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeight {

    private void bfs (int src, List<List<Integer>> adj, int[] distance) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            for (int it : adj.get(node)) {
                if (distance[node] + 1 < distance[it]) {
                    distance[it] = distance[node] + 1;
                    queue.add(node);
                }
            }
        }
    }

    public int[] shortestPath(int[][] edges, int N, int M) {

        // create the adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // add the edges of the graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // source node
            int v = edges[i][1]; // destination node
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        bfs(0, adj, distance);

        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1; // set the value to -1 if unreachable
            }
        }

        return distance;
    }
}
