package dsa.striver.graphs.hardproblems;
/*
    Given a directed graph with V vertices labeled from 0 to V-1.
    The graph is represented using an adjacency list where adj[i] lists
    all nodes adjacent to node i, meaning there is an edge from node
    i to each node in adj[i]. A node is a terminal node if there
    are no outgoing edges. A node is a safe node if every possible
    path starting from that node leads to a terminal node.
    Return an array containing all the safe nodes of the graph
    in ascending order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {

    public int[] eventualSafeNodes(int V, int[][] adj) {

        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (dfs(i, map, adj)) {
                result.add(i);
            }
        }
        int[] resultArr = result.stream()
                .mapToInt(i -> i) // or mapToInt(Integer::intValue)
                .toArray();
        return resultArr;
    }

    // dfs function
    private boolean dfs (int node, Map<Integer,Boolean> map, int[][] adj) {

        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, false);
        for (int neighbour : adj[node]) {
            if (!dfs(neighbour, map, adj)) {
                return false;
            }
        }
        map.put(node, true);
        return true;
    }
}
