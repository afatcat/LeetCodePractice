package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://lintcode.com/en/problem/combination-sum-ii/
 */
public class CombinationSumII {
    /**
     * DFS - backtracking
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(num == null || num.length == 0 || target == 0) {
            return result;
        }

        Arrays.sort(num);
        dfs(result, new ArrayList<>(), num, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] num, int target, int loc) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0) {
            return;
        }

        for (int i = loc; i < num.length; i++) {
            if (i == loc || i == 0 || num[i] != num[i-1]) {
                list.add(num[i]);
                dfs(result, list, num, target - num[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
