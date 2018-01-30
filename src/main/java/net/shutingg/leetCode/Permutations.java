package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sguan on 11/2/17.
 * https://leetcode.com/problems/permutations/description/
 * http://www.lintcode.com/en/problem/permutations/
 */
public class Permutations {
    /**
     * DFS - Backtracking
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        helper(result, new ArrayList<>(), nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i:nums){
            if(!list.contains(i)){
                list.add(i);
                helper(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * Backtracking my own style
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int num:nums){
            helper(nums, num, new ArrayList<>(), result);
        }

        return result;
    }

    private void helper(int[] nums, int currentInt,  List<Integer> currentList, List<List<Integer>> result){
        currentList.add(currentInt);
        if(currentList.size() == nums.length){
            result.add(currentList);
            return;
        }
        int count = 0;
        for(int num:nums){
            if(!currentList.contains(num)){
                if(count != nums.length-currentList.size()){
                    List<Integer> copyList = new ArrayList<>(currentList);
                    helper(nums, num, copyList, result);
                }else{
                    helper(nums, num, currentList, result);
                }
                count++;
            }
        }
    }
}
