package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sguan on 11/2/17.
 */
public class Permutations {
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
