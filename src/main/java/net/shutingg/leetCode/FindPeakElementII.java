package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/find-peak-element-ii/
 *
 * Can be improved to O(m + n)
 */
public class FindPeakElementII {
    int rs;
    int re;

    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0 || A[0].length == 0) {
            return res;
        }

        int n = A.length;
        int m = A[0].length;
        rs = 0;
        re = n - 1;
        while (rs < re) {
            fold(A);
        }
        int r = rs;
        int c = findPeek(A[r]);
        res.add(r);
        res.add(c);
        return res;
    }

    private void fold(int[][] A) {
        int rm = (re - rs) / 2 + rs;
        int peek = findPeek(A[rm]);
        if (rm == rs) {
            if (A[rs][peek] > A[re][peek]) {
                re = rs;
            } else {
                rs = re;
            }
        } else {
            if (A[rm - 1][peek] > A[rm + 1][peek]) {
                re = rm;
            } else {
                rs = rm;
            }
        }
    }

    private int findPeek(int[] arr) {
        int st = 0;
        int end = arr.length - 1;
        int mid = (end - st) / 2 + st;
        while (st + 1 < end) {
            if (arr[mid - 1] > arr[mid]) {
                end = mid;
                mid = (end - st) / 2 + st;
                continue;
            }

            if (arr[mid + 1] > arr[mid]) {
                st = mid;
                mid = (end - st) / 2 + st;
                continue;
            }
            return mid;
        }

        return -1;
    }
}
