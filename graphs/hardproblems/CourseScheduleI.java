package dsa.striver.graphs.hardproblems;

/*

    There are a total of N tasks, labeled from 0 to N-1.
    Given an array arr where arr[i] = [a, b]
    indicates that you must take course b first if you want to take course a.
    Find if it is possible to finish all tasks.


Example 1

Input: N = 4, arr = [[1,0],[2,1],[3,2]]



Output: True

Explanation: It is possible to finish all the tasks in the order : 0 1 2 3.

This problem can be solved using topological sorting.

 */

import java.util.*;

public class CourseScheduleI {

    /* Function to return the topological
    sorting of given graph */
    private int[] topoSort(int V,
                           ArrayList<Integer>[] adj) {

        // To store the In-degrees of nodes
        int[] inDegree = new int[V];

        // Update the in-degrees of nodes
        for (int i = 0; i < V; i++) {

            for(int it : adj[i]) {
                // Update the in-degree
                inDegree[it]++;
            }
        }

        // To store the result
        int[] ans = new int[V];
        int idx = 0;

        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();

        // Add the nodes with no in-degree to queue
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        // Until the queue is empty
        while(!q.isEmpty()) {

            // Get the node
            int node = q.poll();

            // Add it to the answer
            ans[idx++] = node;

            // Traverse the neighbours
            for(int it : adj[node]) {

                // Decrement the in-degree
                inDegree[it]--;

	            /* Add the node to queue if
	            its in-degree becomes zero */
                if(inDegree[it] == 0) q.add(it);
            }
        }

        // Return the result
        return Arrays.copyOfRange(ans, 0, idx);
    }

    /* Function to determine if all
	the tasks can be finished */
    public boolean canFinish(int N, int[][] arr) {

        // To store the graph
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        // Form the graph
        for(int[] it : arr) {
            int u = it[0];
            int v = it[1];

            // Add the edge v-> u
            adj[v].add(u);
        }

        // Get the topological ordering of graph
        int[] topo = topoSort(N, adj);

        /* If it doesn't contain
        all nodes, return false */
        if(topo.length < N) return false;

        // Return true otherwise
        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] arr = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        /* Creating an instance of
        Solution class */
        CourseScheduleI sol = new CourseScheduleI();

        /* Function call to determine if
        all the tasks can be finished */
        boolean ans = sol.canFinish(N, arr);

        // Output
        if(ans)
            System.out.println("All the tasks can be finished.");
        else
            System.out.println("All the tasks can not be finished.");
    }
}
