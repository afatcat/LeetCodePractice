package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/sparse-matrix-multiplication/
 */
public class SparseMatrixMultiplication {
    /**
     * Map of List improved
     *
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply2(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return null;
        }

        int n = A.length;
        if (n == 0) {
            return new int[0][0];
        }
        int k = B.length;
        if (k == 0) {
            return new int[0][0];
        }
        int m = B[0].length;

        int[][] C = new int[n][m];
        Map<Integer, List<Integer>> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (A[i][j] != 0) {
                    list.add(j);
                }
            }
            if (list.size() > 0) {
                mapA.put(i, list);
            }
        }

        Map<Integer, List<Integer>> mapB = new HashMap<>();
        for (int j = 0; j < m; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (B[i][j] != 0) {
                    list.add(i);
                }
            }
            if (list.size() > 0) {
                mapB.put(j, list);
            }
        }

        for (int i = 0; i < n; i++) {
            if (mapA.containsKey(i)) {
                for (int j = 0; j < m; j++) {
                    if (mapB.containsKey(j)) {
                        int p = 0;
                        int q = 0;
                        while (p < mapA.get(i).size() && q < mapB.get(j).size()) {
                            int r = mapA.get(i).get(p);
                            int s = mapB.get(j).get(q);
                            if (r < s) {
                                p++;
                            } else if (r > s) {
                                q++;
                            } else {
                                C[i][j] += A[i][r] * B[r][j];
                                p++;
                                q++;
                            }
                        }
                    }
                }
            }
        }

        return C;
    }

    /**
     * Map of List
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return null;
        }

        int n = A.length;
        if (n == 0) {
            return new int[0][0];
        }
        int k = B.length;
        if (k == 0) {
            return new int[0][0];
        }
        int m = B[0].length;

        int[][] C = new int[n][m];
        Map<Integer, List<Integer>> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int j = k - 1;
            while (j >= 0 && A[i][j] == 0) {
                j--;
            }
            while (j >= 0) {
                list.add(list.size(), A[i][j]);
                j--;
            }
            if (list.size() > 0) {
                mapA.put(i, list);
            }
        }

        Map<Integer, List<Integer>> mapB = new HashMap<>();
        for (int j = 0; j < m; j++) {
            List<Integer> list = new ArrayList<>();
            int i = k - 1;
            while (i >= 0 && B[i][j] == 0) {
                i--;
            }
            while (i >= 0) {
                list.add(list.size(), B[i][j]);
                i--;
            }
            if (list.size() > 0) {
                mapB.put(j, list);
            }
        }

        for (int i = 0; i < n; i++) {
            if (mapA.containsKey(i)) {
                for (int j = 0; j < m; j++) {
                    if (mapB.containsKey(j)) {
                        int p = mapA.get(i).size();
                        int q = mapB.get(j).size();
                        for (int l = 0; l < k && l < p && l < q; l++) {
                            C[i][j] += A[i][l] * B[l][j];
                        }
                    }
                }
            }
        }

        return C;
    }
}
