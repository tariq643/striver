package dsa.striver.binarysearch.array2D;

public class FindRowWithMaximum1s {

    public int rowWithMax1s(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int low = 0, high = n - 1, mid, index = -1, currentRowIndex = 0;
        int countOfCurrentOnes = 0, maxCount = 0;
        for (int i = 0; i < m; i++) {

            low = 0;
            high = n - 1;
            currentRowIndex = n;

            while (low <= high) {
                mid = low + (high - low) / 2;
                // calculating the lower bound of 1
                if (mat[i][mid] >= 1) {
                    currentRowIndex = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            countOfCurrentOnes = n - currentRowIndex;
            if (countOfCurrentOnes > maxCount) {
                maxCount = countOfCurrentOnes;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int[][] matrix = {{0, 0}, {0 ,0}};

        // Create an instance of the Solution class
        FindRowWithMaximum1s sol = new FindRowWithMaximum1s();

        // Print the answer
        System.out.println("The row with maximum number of 1's is: " +
                sol.rowWithMax1s(matrix));
    }
}
