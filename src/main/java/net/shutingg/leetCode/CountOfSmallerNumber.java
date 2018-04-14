package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/count-of-smaller-number/
 */
public class CountOfSmallerNumber {
    /**
     * Binary Search
     *
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> res = new ArrayList<>();
        if (A == null || queries == null || queries.length == 0) {
            return res;
        }

        Arrays.sort(A);
        for (int i = 0; i < queries.length; i++) {
            int count = binarySearch(A, queries[i]);
            res.add(count);
        }

        return res;
    }

    private int binarySearch(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        int st = 0;
        int end = A.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (A[pl] >= target) {
                end = pl;
            } else {
                st = pl;
            }
        }
        if (A[end] < target) {
            return end + 1;
        }
        if (A[st] < target) {
            return st + 1;
        }
        return 0;
    }
}
