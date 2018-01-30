package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://lintcode.com/en/problem/subsets-ii/
 */
public class SubsetsII {
    /**
     * DFS - backtracking
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int p) {
        result.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = p; i < nums.length; i++) {
            if (i == 0 || i == p || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                dfs(result, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
