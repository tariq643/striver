package dsa.striver.graphs.shortestPathAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    /* Function to find the shortest distance of all
    the vertices from the source vertex S. */
    public int[] dijkstra(int V,
                          ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        // Priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        // Distance of source node from itself is 0
        dist[S] = 0;

        // Add the source node to the priority queue
        pq.add(new int[]{0, S});

        // Until the priority queue is empty
        while (!pq.isEmpty()) {

            // Get the tentative distance
            int dis = pq.peek()[0];

            // Get the node
            int node = pq.peek()[1];
            pq.poll();

            // Traverse all its neighbors
            for (ArrayList<Integer> it : adj.get(node)) {

                int adjNode = it.get(0); // node
                int edgeWt = it.get(1); // edge weight

                /* If the tentative distance to
                reach adjacent node is smaller
                than the known distance */
                if (dis + edgeWt < dist[adjNode]) {

                    // Update the known distance
                    dist[adjNode] = dis + edgeWt;

                    // Push the new pair in priority queue
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        // Return the result
        return dist;
    }
}
