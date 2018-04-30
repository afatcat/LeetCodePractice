package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-array-with-same-average/description/
 */
public class SplitArrayWithSameAverage {
    /**
     * DFS
     *
     * @param A
     * @return
     */
    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length <= 1) {
            return false;
        }
        Arrays.sort(A);
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int lenB = 1; lenB <= A.length / 2; lenB++) {
            if (sumA * lenB % A.length == 0 && dfs(A, sumA * lenB / A.length, lenB, 0)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int[] A, int sumB, int lenB, int cur) {
        if (lenB == 0) {
            if (sumB == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (cur >= A.length) {
            return false;
        }

        if (A[cur] > sumB) {
            return false;
        }

        for (int i = cur; i < A.length; i++) {
            if (i > cur && A[i] == A[i - 1]) {
                continue;
            }
            if (dfs(A, sumB - A[i], lenB - 1, i + 1)) {
                return true;
            }
        }

        return false;
    }
}
