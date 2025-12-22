package dsa.striver.graphs.hardproblems;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInUndirectedGraphWithUnitWeight {

    public int[] shortestPath(int[][] edges, int N, int M) {

        // create the adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] distance = new int[N];
        return distance;
    }
}
