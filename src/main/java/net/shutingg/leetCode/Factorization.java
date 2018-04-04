package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/factorization/
 */
public class Factorization {
    /**
     * Combination DFS
     *
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, 2, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int from, List<Integer> cur) {
        if (n == 1) {
            if (cur.size() == 1) {
                return;
            }
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = from; i <= n; i++) {
            if (i > n / i) {
                break;
            }
            if (n % i != 0) {
                continue;
            }

            cur.add(i);
            dfs(res, n / i, i, cur);
            cur.remove(cur.size() - 1);
        }

        cur.add(n);
        dfs(res, 1, n, cur);
        cur.remove(cur.size() - 1);
    }
}
