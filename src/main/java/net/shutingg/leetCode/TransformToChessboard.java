package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/transform-to-chessboard/
 *
 * An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.

 What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.

 Notice

 board will have the same number of rows and columns, a number in the range [2, 30].
 board[i][j] will be only 0s or 1s.

 Example
 Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 Output: 2
 Explanation:
 One potential sequence of moves is shown below, from left to right:

 0110     1010     1010
 0110 --> 1010 --> 0101
 1001     0101     1010
 1001     0101     0101

 The first move swaps the first and second column.
 The second move swaps the second and third row.


 Input: board = [[0, 1], [1, 0]]
 Output: 0
 Explanation:
 Also note that the board with 0 in the top left corner,
 01
 10

 is also a valid chessboard.

 Input: board = [[1, 0], [1, 0]]
 Output: -1
 Explanation:
 No matter what sequence of moves you make, you cannot end with a valid chessboard.
 */
public class TransformToChessboard {
    private int rowZeros = 0;
    private int rowOnes = 0;
    private int columnZeros = 0;
    private int columnOnes = 0;

    /**
     * @param board: the given board
     * @return: the minimum number of moves to transform the board into a "chessboard"
     */
    public int movesToChessboard(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            return -1;
        }

        if (!(validateRows(board) && validateColumns(board) && validateRowCount(board) && validateColumnCount(board))) {
            return -1;
        }

        return countColumnMoves(board) + countRowMoves(board);
    }

    private boolean validateRows(int[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            int diffCount = 0;
            for (int j = 0; j < board[i].length; j++) {
                diffCount += (board[i][j] ^ board[i + 1][j]);
            }
            if (diffCount != 0 && diffCount != board[i].length) {
                return false;
            }
        }

        return true;
    }

    private boolean validateColumns(int[][] board) {
        for (int j = 0; j < board[0].length -1; j++) {
            int diffCount = 0;
            for (int i = 0; i < board.length; i++) {
                diffCount += (board[i][j] ^ board[i][j + 1]);
            }
            if (diffCount != 0 && diffCount != board.length) {
                return false;
            }
        }

        return true;
    }

    private boolean validateRowCount(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 0) {
                rowZeros++;
            } else {
                rowOnes++;
            }
        }
        if (rowZeros == board.length / 2 || rowOnes == board.length / 2) {
            return true;
        }

        return false;
    }

    private boolean validateColumnCount(int[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 0) {
                columnZeros++;
            } else {
                columnOnes++;
            }
        }

        if (columnZeros == board[0].length / 2 || columnOnes == board[0].length / 2) {
            return true;
        }

        return false;
    }

    private int countColumnMoves(int[][] board) {
        if ((board[0].length & 1) == 1) {
            int larger = 1;
            if (columnZeros > columnOnes) {
                larger = 0;
            }

            int wrongCol = 0;
            for (int j = 0; j < board[0].length; j = j + 2) {
                if (board[0][j] != larger) {
                    wrongCol++;
                }
            }
            return wrongCol;
        } else {
            int zeroFirst = 0;
            int oneFirst = 0;
            for (int j = 0; j < board[0].length; j = j + 2) {
                if (board[0][j] == 0) {
                    oneFirst++;
                } else {
                    zeroFirst++;
                }
            }

            return Math.min(zeroFirst, oneFirst);
        }
    }

    private int countRowMoves(int[][] board) {
        if ((board.length & 1) == 1) {
            int larger = 1;
            if (rowZeros > rowOnes) {
                larger = 0;
            }

            int wrongRow = 0;
            for (int i = 0; i < board.length; i = i + 2) {
                if (board[i][0] != larger) {
                    wrongRow++;
                }
            }
            return wrongRow;
        } else {
            int zeroFirst = 0;
            int oneFirst = 0;
            for (int i = 0; i < board.length; i = i + 2) {
                if (board[i][0] == 0) {
                    oneFirst++;
                } else {
                    zeroFirst++;
                }
            }

            return Math.min(zeroFirst, oneFirst);
        }
    }
}
