package dsa.striver.graphs.hardproblems;

/*

    There are a total of N tasks, labeled from 0 to N-1. Given an array arr where arr[i] = [a, b] indicates that you must take course b first if you want to take course a.
    Find the order of tasks you should pick to finish all tasks.

If no such ordering exists, return an empty array.

Since multiple valid answers are possible,
 the final output will be 1 if your solution is correct, otherwise 0.


Example 1

Input: N = 4, arr = [[1,0],[2,1],[3,2]]

Output: [0, 1, 2, 3]

Explanation: First,finish task 0, as it has no prerequisites.
Then,finish task 1, since it depends only on task 0.
After that,finish task 2, since it depends only on task 1.
Finally,finish task 3, since it depends only on task 2

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

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
    public int[] findOrder(int N, int[][] graph) {

        // To store the graph
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        // Form the graph
        for(int[] it : graph) {
            int u = it[0];
            int v = it[1];

            // Add the edge v-> u
            adj[v].add(u);
        }

        // Get the topological ordering of graph
        int[] topo = topoSort(N, adj);

        /* If it doesn't contain
        all nodes, return false */
        if(topo.length < N) return new int[]{};

        // Return true otherwise
        return topo;
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
        CourseScheduleII sol = new CourseScheduleII();

        /* Function call to determine if
        all the tasks can be finished */
        int[] ans = sol.findOrder(N, arr);

        // Output
        Arrays.stream(ans).forEach(System.out::println);
    }
}
