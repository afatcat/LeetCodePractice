package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * http://lintcode.com/en/problem/combination-sum/
 */
public class CombinationSum {
    /**
     * DFS - backtracking
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(candidates);
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int st) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for (int i = st; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }


    /**
     * Backtracking - my way
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        track(candidates, target, new ArrayList<>(), result, 0);

        return result;
    }

    private void track(int[] candidates, int remain, List<Integer> current, List<List<Integer>> result, int start){
        for(int i=start; i<candidates.length; i++){
            if(remain - candidates[i] > 0){
                List<Integer> newList = new ArrayList<>(current);
                newList.add(candidates[i]);
                track(candidates, remain - candidates[i], newList, result, i);
            }else if(remain - candidates[i] == 0){
                current.add(candidates[i]);
                result.add(current);
                return;
            }else{
                return;
            }
        }
    }
}
