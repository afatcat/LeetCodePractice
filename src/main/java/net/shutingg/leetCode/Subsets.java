package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * backtracking - with remove
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int st) {
        result.add(new ArrayList(list));
        if (list.size() == nums.length) {
            return;
        }

        for(int i = st; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Backtracking my way
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i <nums.length; i++){
            List<Integer> list = new ArrayList<>();
            process(result, list, i, nums);
        }
        result.add(new ArrayList<>());

        return result;
    }


    private void process(List<List<Integer>> result, List<Integer> current, int loc, int[] nums){
        current.add(nums[loc]);
        result.add(current);
        for(int i=loc+1; i<nums.length; i++){
            List<Integer> newList = new ArrayList<>(current);
            process(result, newList, i, nums);
        }
    }
}
