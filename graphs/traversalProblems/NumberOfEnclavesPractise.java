package dsa.striver.graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclavesPractise {

    private int delRow[] = {-1, 0, 1 ,0};
    private int delCol[] = {0, 1, 0 ,-1};

    private boolean isValid(int i, int j, int m, int n) {

        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j>= n) {
            return false;
        }
        return true;
    }

    private void bfs (int[][] grid, Queue<int[]> queue, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {

                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, m ,n)
                        && grid[newRow][newCol] == 1
                        && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    // Function to find number of enclaves
    public int numberOfEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // add the border elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && grid[i][j] == 1) {

                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }

        /* Perform the bfs traversal
        from border land cells */
        bfs(grid, queue, visited);
        
        int numberOfEnclaves = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    numberOfEnclaves++;
                }
            }
        }

        return numberOfEnclaves;
    }
}
