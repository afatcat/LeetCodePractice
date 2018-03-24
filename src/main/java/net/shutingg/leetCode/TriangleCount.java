package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * http://www.lintcode.com/en/problem/triangle-count/
 */
public class TriangleCount {
    /**
     * O(n^2)
     *
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if (S == null || S.length < 3) {
            return 0;
        }

        int count = 0;
        Arrays.sort(S);
        for (int i = S.length - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (S[j] + S[k] > S[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }
}
