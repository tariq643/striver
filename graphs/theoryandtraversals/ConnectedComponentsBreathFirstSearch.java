package dsa.striver.graphs.theoryandtraversals;

import java.util.*;

public class ConnectedComponentsBreathFirstSearch {

    private void bfsOfGraph (int node, boolean[] visited, List<Integer>[] adjacencyList) {

        Queue<Integer> integerQueue = new LinkedList<>();
        visited[node] = true;

        integerQueue.add(node);

        while (!integerQueue.isEmpty()) {
            int current = integerQueue.poll();
            for (int neighbour : adjacencyList[current]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    integerQueue.add(neighbour);
                }
            }
        }
    }

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

        // create a adjancy list from edges
        int E = edges.size();

        List<Integer>[] adjacencyList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            adjacencyList[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjacencyList[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        // array to store whether it has been visited or not
        boolean visited[] = new boolean[V];

        int numberOfComponents = 0;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                numberOfComponents++;
                bfsOfGraph(i, visited, adjacencyList);
            }
        }
        return numberOfComponents;
    }

    public static void main(String[] args) {

        // time complexity : O(V+E)

        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        );

        /* Creating an instance of
        Solution class */
        ConnectedComponentsBreathFirstSearch sol = new ConnectedComponentsBreathFirstSearch();

        /* Function call to find the number of
        connected components in the given graph */
        int ans = sol.findNumberOfComponent(V, edges);

        System.out.println("The number of components in the given graph is: " + ans);
    }
}
