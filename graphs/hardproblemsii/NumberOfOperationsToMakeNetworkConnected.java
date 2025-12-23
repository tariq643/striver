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

public class NumberOfOperationsToMakeNetworkConnected {

    public int solve(int n, int[][] edges) {

        int size = edges.length;
        if (size < n - 1) {
            return -1;
        }
        int count = 0;
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] connection : edges) {
            int u = connection[0];
            int v = connection[1];
            disjointSet.unionBySize(u, v);
        }

        // To store count of required edges
        // Finding the number of components
        for(int i=0; i<n; i++) {
            if(disjointSet.parent[i] == i) count++;
        }

        return count - 1;
    }
}


class DisjointSet {
    /* To store the ranks, parents and
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}