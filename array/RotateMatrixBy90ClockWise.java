package dsa.striver.array;

public class RotateMatrixBy90ClockWise {

    public void rotateMatrix(int[][] matrix) {

        this.transpose(matrix);

        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            reverse(matrix, i);
        }
    }

    private void reverse(int[][] matrix, int currentRow) {

        int width = matrix[currentRow].length;
        for (int i = 0; i < width / 2; i++) {
            int temp = matrix[currentRow][i];
            matrix[currentRow][i] = matrix[currentRow][width - i - 1];
            matrix[currentRow][width - i - 1] = temp;
        }
    }

    private void transpose(int[][] matrix) {

        int length = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    static void main() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Create an instance of the Solution class
        RotateMatrixBy90ClockWise sol = new RotateMatrixBy90ClockWise();

        // Rotate the matrix
        sol.rotateMatrix(arr);

        // Output the rotated matrix
        System.out.println("Rotated Image:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
