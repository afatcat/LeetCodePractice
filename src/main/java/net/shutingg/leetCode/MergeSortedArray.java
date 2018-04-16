package net.shutingg.leetCode;

public class MergeSortedArray {
    /**
     * Algorithm 9-1
     *
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null || A.length < m + n || m + n == 0) {
            return;
        }

        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        while (i >= 0) {
            if (k < 0 || j >= 0 && A[j] > B[k]) {
                A[i] = A[j];
                i--;
                j--;
            } else {
                A[i] = B[k];
                i--;
                k--;
            }
        }
    }
}
