package dsa.striver.graphs.hardproblemsii;

/*

Given a graph with n vertices and m edges.
The graph is represented by an array Edges,
where Edge[i] = [a, b] indicates an edge between vertices a and b.
One edge can be removed from anywhere and added between any
two vertices in one operation.
Find the minimum number of operations that will
be required to make the graph connected.
If it is not possible to make the graph connected, return -1.


Example 1

Input : n = 4, Edge =[ [0, 1], [ 0, 2], [1, 2]]

 */

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {

    public int solve(int n, int[][] edges) {

        // create an adjacency list from the edge array
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        return -1;
    }

    static void main() {

    }
}
