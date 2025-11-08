package dsa.striver.recursion.faqHard;

public class WordSearch {

    private boolean recursiveBoardSearch (char[][] board, int i, int j, String word, int k) {

        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean ans = recursiveBoardSearch(board, i+1, j, word, k + 1) ||
                recursiveBoardSearch(board, i, j+1, word, k + 1) ||
                recursiveBoardSearch(board, i-1, j, word, k + 1) ||
                recursiveBoardSearch(board, i, j-1, word, k + 1);

        board[i][j] = temp;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        //your code goes here

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // start the search
                    if (recursiveBoardSearch (board, i , j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
