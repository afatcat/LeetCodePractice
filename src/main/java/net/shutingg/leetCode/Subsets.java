package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i <nums.length; i++){
            List<Integer> list = new LinkedList<>();
            process(result, list, i, nums);
        }
        result.add(new LinkedList<>());

        return result;
    }


    private void process(List<List<Integer>> result, List<Integer> current, int loc, int[] nums){
        current.add(nums[loc]);
        result.add(current);
        for(int i=loc+1; i<nums.length; i++){
            List<Integer> newList = new LinkedList<>(current);
            process(result, newList, i, nums);
        }
    }
}
