package dsa.striver.array;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {

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
        return matrix;
    }

    static void main() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Create an instance of the Solution class
        TransposeMatrix sol = new TransposeMatrix();

        // Rotate the matrix
        sol.transpose(arr);

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
