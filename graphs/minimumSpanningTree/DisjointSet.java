package dsa.striver.graphs.minimumSpanningTree;

import java.util.Arrays;

public class DisjointSet {

    private int rank[];
    private int parent[];
    private int size[];

    public DisjointSet(int n) {

        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    private int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]); // path compression
    }

    public boolean find(int u, int v) {
        return findUPar(u) == findUPar(v);
    }

    public void unionByRank(int u, int v) {

        int ultimateParentU = findUPar(u);
        int ultimateParentV = findUPar(v);

        // they belong to the same component
        if (ultimateParentU == ultimateParentV) {
            return;
        }

        if (rank[ultimateParentU] < rank[ultimateParentV]) {
            parent[ultimateParentU] = parent[ultimateParentV];
        }
        else if (rank[ultimateParentU] > rank[ultimateParentV]) {
            parent[ultimateParentV] = parent[ultimateParentU];
        }
        else {
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }

    public void unionBySize(int u, int v) {

        int ultimateParentU = findUPar(u);
        int ultimateParentV = findUPar(v);

        // they belong to the same component
        if (ultimateParentU == ultimateParentV) {
            return;
        }

        if (size[ultimateParentU] < size[ultimateParentV]) {
            parent[ultimateParentU] = parent[ultimateParentV];
            size[ultimateParentV] = size[ultimateParentV] + size[ultimateParentU];
        }
        else if (size[ultimateParentV] < size[ultimateParentU]) {
            parent[ultimateParentV] = parent[ultimateParentU];
            size[ultimateParentU] = size[ultimateParentU] + size[ultimateParentV];
        }
        else {
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] = size[ultimateParentU] + size[ultimateParentV];
        }
    }
}
