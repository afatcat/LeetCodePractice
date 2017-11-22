package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
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
