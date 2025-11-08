package dsa.striver.graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesPractise {

    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0 ,-1};

    private boolean isValid (int i, int j, int m, int n) {

        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j >= n) {
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int time = 0;
        int totalNumberOfOranges = 0;
        int countOfRottenOranges = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0) {
                    totalNumberOfOranges++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {

            int k = queue.size();
            countOfRottenOranges = countOfRottenOranges + k;

            while (k-- > 0) {

                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Traverse its 4 neighbors
                for(int i = 0; i < 4; i++) {

                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];

                    if (isValid(newRow, newCol, m, n) &&
                            grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            if (!queue.isEmpty())
                time++;
        }
        if (totalNumberOfOranges == countOfRottenOranges)
            return time;
        return  -1;
    }
}
