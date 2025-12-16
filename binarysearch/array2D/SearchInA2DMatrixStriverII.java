package dsa.striver.binarysearch.array2D;

public class SearchInA2DMatrixStriverII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        SearchInA2DMatrixStriverII searchIn2DMatrix = new SearchInA2DMatrixStriverII();
        int mat[][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        System.out.println(searchIn2DMatrix.searchMatrix(mat, 8));
    }
}
