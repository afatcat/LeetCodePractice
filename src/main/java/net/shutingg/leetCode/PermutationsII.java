package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii
 */
public class PermutationsII {
    /*
    Backtracking solution
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, used, nums, new LinkedList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, boolean[] used, int[] nums, LinkedList<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
        }else{
            for(int i=0; i < nums.length; i++){
                if(!used[i]){
                    //to prevent duplicates
                    if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                        continue;
                    }

                    used[i] = true;
                    current.add(nums[i]);
                    dfs(result, used, nums, current);
                    current.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
