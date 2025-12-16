package dsa.striver.array.faqMedium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralManner {

    public List<Integer> spiralOrder(int[][] matrix) {

        // have four variables
        List<Integer> output = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;
        while (top <= bottom && left <= right) {
            // print the matrix from left to right
            for (int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;
            // print the matrix from top to bottom
            for (int i = top; i <= right; i++) {
                output.add(matrix[i][right]);
            }
            right--;
            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    output.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    output.add(matrix[i][left]);
                }
                left++;
            }
        }
        return output;
    }
}
