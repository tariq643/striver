package dsa.striver.graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    // DelRow and delCol for neighbors
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};

    /* Helper Function to check if a
    cell is within boundaries */
    private boolean isValid(int i, int j,
                            int n, int m) {

        // Return false if cell is invalid
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;

        // Return true if cell is valid
        return true;
    }

    /* Function to find number of minutes
    so that all oranges get rotten */
    public int orangesRotting(int[][] grid){

        // Get the dimensions of grid
        int m = grid.length;
        int n = grid[0].length;

        /* Variable to store time taken
        to get all oranges rotten */
        int time = 0;

        /* Variable to store
        total count of oranges */
        int total = 0;

        /* Variable to store count of
         oranges that are rotten */
        int rottenOrangesCount = 0;

        // Queue to perform BFS
        Queue<int[]> q = new LinkedList<>();

        // Traverse the grid
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                /* If cell contains orange,
                increment total */
                if(grid[i][j] != 0) total++;

                /* If cell contains rotten
                 orange, push in queue */
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // Perform BFS

        // Until the queue is empty
        while(!q.isEmpty()) {

            // Get the size of queue
            int k = q.size();

            // Update count of rotten oranges
            rottenOrangesCount += k;

            // Perform BFS for current level
            while(k-- > 0) {

                // Get the cell from queue
                int[] cell = q.poll();

                // Get its coordinates
                int row = cell[0];
                int col = cell[1];

                // Traverse its 4 neighbors
                for(int i = 0; i < 4; i++) {

                    // Coordinates of new cell
                    int nRow = row + delRow[i];
                    int nCol = col + delCol[i];

                    /* check for valid, unvisited
                     cells having fresh oranges */
                    if(isValid(nRow, nCol, m, n) &&
                            grid[nRow][nCol] == 1) {

                        /* Mark the new orange as rotten
                        and add it to the queue */
                        grid[nRow][nCol] = 2;
                        q.add(new int[]{nRow, nCol});
                    }
                }
            }

            /* If new oranges are rotten, then
             the time must be incremented */
            if(!q.isEmpty()) time++;
        }

        /* If all the oranges are rotten,
        return the time taken */
        if(total == rottenOrangesCount) return time;

        // Otherwise return -1
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        /* Creating an instance of
        Solution class */
        RottenOranges sol = new RottenOranges();

        /* Function call to find number of minutes
        so that all oranges get rotten */
        int ans = sol.orangesRotting(grid);

        System.out.println("The minimum number of minutes required for all oranges to rotten are: " + ans);
    }
}
