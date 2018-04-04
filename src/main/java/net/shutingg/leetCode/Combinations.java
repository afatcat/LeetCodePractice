package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/combinations/
 */
public class Combinations {
    /**
     * Combination DFS
     *
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }

        dfs(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int index, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i <= n; i++) {
            cur.add(i);
            dfs(res, n, k, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
