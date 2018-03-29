package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * http://www.lintcode.com/en/problem/wood-cut/
 */
public class WoodCut {
    /**
     * Binary Search
     *
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0 || k <= 0) {
            return 0;
        }
        Arrays.sort(L);
        int st = 1;
        int end = L[L.length - 1];
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            int count = countWood(pl, L);
            if (count < k) {
                end = pl;
            } else {
                st = pl;
            }
        }

        if (countWood(end, L) >= k) {
            return end;
        } else if (countWood(st, L) >= k) {
            return st;
        }
        return 0;
    }

    int countWood(int length, int[] woods) {
        int count = 0;
        for (int i = 0; i < woods.length; i++) {
            count += woods[i] / length;
        }
        return count;
    }
}
