package dsa.striver.binarysearch.array2D;

public class SearchInA2DMatrixStriver {

    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length, n = mat[0].length;

        int beg = 0, end = m - 1;
        while (beg <= end) {

            int midRow = beg + (end - beg) / 2;

            if (target >= mat[midRow][0] && target <= mat[midRow][n - 1]) {
                return searchInRow (mat, target, midRow);
            }
            else if (target >= mat[midRow][n - 1]) {
                beg = midRow + 1;
            }
            else {
                end = midRow - 1;
            }
        }
        return false;
    }

    private boolean searchInRow (int[][] matrix, int target, int mid) {

        int start = 0, end = matrix[0].length - 1;

        while (start <= end) {
            int midOfTheRow = start + (end - start) / 2;
            if (matrix[mid][midOfTheRow] == target) {
                return true;
            }
            else if (target > matrix[mid][midOfTheRow]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        SearchInA2DMatrixStriver searchIn2DMatrix = new SearchInA2DMatrixStriver();
        int mat[][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        System.out.println(searchIn2DMatrix.searchMatrix(mat, 8));
    }
}
