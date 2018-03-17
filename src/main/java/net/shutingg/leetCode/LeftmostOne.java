package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/leftmost-one/
 *
 * Given a 2D array, and each line has only 0 and 1, the front part is 0, and the latter part is 1. Find the number of columns in the leftmost 1 of all the rows in the array.

 Notice

 The number of rows in the array and the number of columns do not exceed 1000
 In order to limit the time complexity, your program will run 50000 times
 Have you met this question in a real interview? Yes
 Example
 Given arr = [[0,0,0,1],[1,1,1,1]], return 0.

 Explanation:
 Arr[1][0] is the leftmost 1 in all rows and its column is 0.
 Given arr = [[0,0,0,1],[0,1,1,1]], return 1.

 Explanation:
 Arr[1][1] is the leftmost 1 in all rows and its column is 1.
 */
public class LeftmostOne {
    /**
     * Binary Search
     *
     * @param arr: The 2-dimension array
     * @return: Return the column the leftmost one is located
     */
    public int getColumn(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int result = arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            int r = findFirstOne(arr[i]);
            result = Math.min(result, r);
        }

        return result;
    }

    private int findFirstOne(int[] row) {
        if (row[row.length - 1] == 0) {
            return row.length;
        }
        int left = 0;
        int right = row.length - 1;
        int pl = (left + right) / 2;
        while (left + 1 < right) {
            if (row[pl] == 0) {
                left = pl + 1;
                pl = (left + right) / 2;
            } else {
                right = pl;
                pl = (left + right) / 2;
            }
        }
        if (row[left] == 1) {
            return left;
        }
        return right;
    }
}
