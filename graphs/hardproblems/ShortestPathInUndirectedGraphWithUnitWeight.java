package dsa.striver.graphs.hardproblems;

import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeight {

    private void bfs (int src, List<List<Integer>> adj, int[] distance) {

        Queue<Integer> queue = new LinkedList<>();
        distance[0] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            for (int it : adj.get(node)) {
                if (distance[node] + 1 < distance[it]) {
                    distance[it] = distance[node] + 1;
                }
                queue.add(it);
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

    static void main() {
        int N = 9, M = 10;
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4},
                {4, 5}, {5, 6}, {1, 2},
                {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        /* Creating an instance of
        Solution class */
        ShortestPathInUndirectedGraphWithUnitWeight sol = new ShortestPathInUndirectedGraphWithUnitWeight();

        /* Function call to determine shortest paths */
        int[] ans = sol.shortestPath(edges, N, M);

        // Output
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
