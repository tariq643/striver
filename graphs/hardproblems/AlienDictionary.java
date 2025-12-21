package dsa.striver.graphs.hardproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    private List<Integer> topoSort (int k, List<Integer>[] adj) {

        // To store the In-degrees of nodes
        int[] inDegree = new int[k];

        // Update the in-degrees of nodes
        for (int i = 0; i < k; i++) {

            for (int it : adj[i]) {
                // Update the in-degree
                inDegree[it]++;
            }
        }

        // To store the result
        List<Integer> ans = new ArrayList<>();

        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();

        // Add the nodes with no in-degree to queue
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        // Until the queue is empty
        while (!q.isEmpty()) {

            // Get the node
            int node = q.poll();

            // Add it to the answer
            ans.add(node);

            // Traverse the neighbours
            for (int it : adj[node]) {

                // Decrement the in-degree
                inDegree[it]--;

                /* Add the node to queue if
                its in-degree becomes zero */
                if (inDegree[it] == 0) q.add(it);
            }
        }

        // Return the result
        return ans;
    }

    public String findOrder(String [] dict, int N, int K) {

        // create an adj list to store the words in the dict
        List<Integer>[] adj = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int minLength = Math.min(s1.length(), s2.length());
            for (int p = 0; p < minLength; p++) {
                if (s1.charAt(p) != s2.charAt(p)) {
                    adj[s1.charAt(p) - 'a'].add(s2.charAt(p) - 'a');
                    break;
                }
            }
        }

        /* Get the topological sort
        of the graph formed */
        List<Integer> topo = this.topoSort(K, adj);

        // To store the answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < K; i++) {
            // Add the letter to the result
            ans.append((char) ('a' + topo.get(i)));
            ans.append(' ');
        }

        // Return the answer
        return ans.toString();
    }
}
