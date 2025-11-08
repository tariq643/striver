package dsa.striver.graphs.cycles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    private boolean bfsOfGraph(int node, List<List<Integer>> adj, int[] colors) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbour : adj.get(currentNode)) {
                if (colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[currentNode];
                    queue.add(neighbour);
                }
                else if (colors[neighbour] == colors[currentNode]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, List<List<Integer>> adj) {

        int colors[] = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!bfsOfGraph(i, adj, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
