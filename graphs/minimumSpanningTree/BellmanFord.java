package dsa.striver.graphs.minimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {

        // To store the distance
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        // Distance of source from itself is zero
        dist[S] = 0;

        // Repeat for V-1 times
        for(int i = 0; i < V-1; i++) {

            // Iterate on all the edges
            for(ArrayList<Integer> it : edges) {

                int u = it.get(0); // node 1
                int v = it.get(1); // node 2
                int wt = it.get(2); // edge weight

                // Edge relaxation
                if(dist[u] != 1e9 &&
                        dist[u] + wt < dist[v]) {

                    // Updating the known distance
                    dist[v] = dist[u] + wt;
                }
            }
        }

        /* An extra relaxation to check if the
        graph consists of a negative cycle */
        for(ArrayList<Integer> it : edges) {

            int u = it.get(0); // node 1
            int v = it.get(1); // node 2
            int wt = it.get(2); // edge weight

            /* If edge relaxation is possible,
            negative cycle exists */
            if(dist[u] != 1e9 &&
                    dist[u] + wt < dist[v]) {

                // Return {-1}
                return new int[]{-1};
            }
        }

        // Return the computed result
        return dist;
    }
}
