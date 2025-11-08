package dsa.striver.graphs.traversalProblems;

import java.util.Arrays;

public class FloodFillAlgorithmDFSPractise {

    private int delRow[] = {-1, 0, 1, 0};
    private int delCol[] = {0, 1, 0, -1};

    private boolean isValid (int newRow, int newCol, int m, int n) {

        if (newRow < 0 || newRow >= m) {
            return false;
        }
        if (newCol < 0 || newCol >= n) {
            return false;
        }
        return true;
    }

    private void dfsOnGrid (int row, int column, int[][] image, int[][] answer, int initialColor, int newColor) {

        answer[row][column] = newColor;

        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < 4; i++) {

            int newRow = row + delRow[i];
            int newColumn = column + delCol[i];

            // if the newRow and
            if (isValid(newRow, newColumn, m, n) && image[newRow][newColumn] == initialColor
                && answer[newRow][newColumn] != newColor) {
                dfsOnGrid(newRow, newColumn, image, answer, initialColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // get the initial color
        int initialColor = image[sr][sc];

        // create the answer matrix because dfs will be run on the initial matrix
        int[][] answer = new int[image.length][image[0].length];


        for (int i = 0; i < image.length; i++) {
            answer[i] = Arrays.copyOf(image[i], image[0].length);
        }

        // call the depth first search
        dfsOnGrid (sr, sc, image, answer, initialColor, newColor);

        return answer;
    }
}
