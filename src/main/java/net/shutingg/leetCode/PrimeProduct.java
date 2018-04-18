package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/prime-product/
 */
public class PrimeProduct {
    /**
     * DFS
     *
     * @param arr: The prime array
     * @return: Return the array of all of prime product
     */
    public int[] getPrimeProduct(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            dfs(arr, i, 1, 1, res);
        }

        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private void dfs(int[] arr, int cur, int product, int count, List<Integer> res) {
        product = arr[cur] * product;
        if (count > 1) {
            res.add(product);
        }
        for (int i = cur + 1; i < arr.length; i++) {
            dfs(arr, i, product, count + 1, res);
        }
    }
}
