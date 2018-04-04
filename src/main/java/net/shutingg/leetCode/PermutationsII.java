package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii
 */
public class PermutationsII {
    private boolean end = false;
    /**
     * Next Permutation
     *
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        if (nums.length <= 1) {
            res.add(arrayToList(nums));
            return res;
        }

        Arrays.sort(nums);

        while (!end) {
            res.add(arrayToList(nums));
            nextP(nums);
        }

        return res;
    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private void nextP(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            end = true;
            return;
        }
        int j = nums.length - 1;
        while (j > i) {
            if (nums[j] > nums[i]) {
                swap(nums, i, j);
                flip(nums, i + 1, nums.length - 1);
                break;
            }
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void flip(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }

        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }



    /**
     * Backtracking solution
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
