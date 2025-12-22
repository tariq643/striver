package dsa.striver.graphs.shortestPathAlgorithm;

/*

    Given an n x m matrix grid where each cell contains either
0 or 1, determine the shortest distance between a source cell and a destination cell.
You can move to an adjacent cell (up, down, left, or right) if
that adjacent cell has a value of 1. The path can only
be created out of cells containing 1.
If the destination cell is not reachable from the source cell, return -1.


Example 1

Input: grid = [[1, 1, 1, 1],[1, 1, 0, 1],[1, 1, 1, 1],
[1, 1, 0, 0],[1, 0, 0, 1]], source = [0, 1], destination = [2, 2]

Output: 3

Explanation: The shortest
path from (0, 1) to (2, 2) is:

Move down to (1, 1)

Move down to (2, 1)

Move right to (2, 2)

Thus, the shortest distance is 3


 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {

    // Delta row and column array
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};

    // Function to check if a cell is valid
    private boolean isValid(int row, int col,
                            int n, int m) {

        // Return false if the cell is invalid
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;

        // Return true if the cell is valid
        return true;
    }

    /* Function to determine the shortest distance
    between source and destination */
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (source[0] == destination[0] &&
            source[1] == destination[1]) {
            return 0;
        }

        // queue for Dijkstra algorithm
        Queue<int[]> queue = new LinkedList<>();

        // dimensions of the grid
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[source[0]][source[1]] = 0;
        queue.add(new int[]{0, source[0], source[1]});

        while (!queue.isEmpty()) {

            int[] it = queue.poll();
            int dis = it[0]; // Distance
            int row = it[1]; // Row of cell
            int col = it[2]; // Column of cell

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (isValid(newRow, newCol, n, m)
                   && grid[newRow][newCol] == 1 && dis + 1 < distance[newRow][newCol]) {
                    // edge relaxation
                    distance[newRow][newCol] = 1 + dis;

                    /* Return the distance if the
                    destination is reached */
                    if (newRow == destination[0] &&
                            newCol == destination[1]) {
                        return dis + 1;
                    }

                    // Add the new cell to queue
                    queue.add(new int[]{1 + dis, newRow, newCol});
                }
            }
        }
        return -1;
    }
}
