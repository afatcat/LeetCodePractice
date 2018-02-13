package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/word-search/
 */
public class WordSearch {
    private static int[] xa = {0, 1, 0, -1};
    private static int[] ya = {1, 0, -1, 0};
    /**
     * DFS
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        char[] wc = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, wc, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] wc, int loc, int i, int j) {
        if (board[i][j] == 0) {
            return false;
        }
        if (!(board[i][j] == wc[loc])) {
            return false;
        }
        if(wc.length == loc + 1) {
            return true;
        }

        for(int k = 0; k < 4; k++) {
            int x = xa[k] + j;
            int y = ya[k] + i;
            if (x >= 0 && x < board[0].length && y >= 0 && y < board.length){
                char origin = board[i][j];
                board[i][j] = 0;
                if (dfs(board, wc, loc+1, y, x)) {

                    return true;
                }
                board[i][j] = origin;
            }
        }
        return false;
    }
}
