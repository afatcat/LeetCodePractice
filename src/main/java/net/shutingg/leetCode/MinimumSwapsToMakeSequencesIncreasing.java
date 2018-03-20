package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    /**
     * DP
     *
     * @param A
     * @param B
     * @return
     */
    public int minSwap(int[] A, int[] B) {
        //f[i, 0] = f[i - 1, 0] | i - 1 original order valid with i original
        //          f[i - 1, 1] | i - 1 flipped order valid with i flipped
        //f[i, 1] = f[i - 1, 0] + 1 | i - 1 original order valid with i flipped
        //          f[i - 1, 1] + 1 | i - 1 flipped order valid with i flipped

        if (A == null || B == null || A.length != B.length) {
            return -1;
        }

        int n = A.length;
        if (n != B.length) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = Integer.MAX_VALUE;
            f[i][1] = Integer.MAX_VALUE;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][0]);
                f[i][1] = Math.min(f[i][1], f[i - 1][1] + 1);
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }
}
