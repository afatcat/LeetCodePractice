package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://lintcode.com/en/problem/n-queens/
 */
public class NQueens {
    /**
     * DFS - Backtracking
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0) {
            return result;
        }

        List<Integer> cols = new ArrayList<>();

        dfs(result, cols, n);
        return result;
    }

    private boolean isValid(List<Integer> cols, int col) {
        int r = cols.size();
        for(int i = 0; i < r; i++) {
            if (cols.get(i) == col) {
                return false;
            }

            if (r-i == Math.abs(col - cols.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<String>> result, List<Integer> cols, int n) {
        if(cols.size() == n) {
            result.add(draw(cols));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                dfs(result, cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }

    private List<String> draw(List<Integer> cols) {
        List<String> result = new ArrayList<>();
        if(cols == null || cols.size() == 0) {
            return result;
        }
        for (int col:cols) {
            String str = "";
            for (int i = 0; i < cols.size(); i++) {
                if(i == col) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            result.add(str);
        }
        return result;
    }
}
