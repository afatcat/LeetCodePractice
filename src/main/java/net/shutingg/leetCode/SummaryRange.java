package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if(nums == null || nums.length==0){
            return result;
        }
        processNums(result, nums, 1, nums[0], nums[0]);
        return result;
    }

    private void processNums(List<String> list, int[] nums, int loc, int prev, int start){
        if(loc>=nums.length){
            if(start!=prev){
                list.add(start+"->"+prev);
            }else{
                list.add(""+prev);
            }
            return;
        }
        if(nums[loc]!=prev+1){
            if(start!=prev){
                list.add(start+"->"+prev);
                processNums(list, nums, loc+1, nums[loc], nums[loc]);
            }else{
                list.add(""+prev);
                processNums(list, nums, loc+1, nums[loc], nums[loc]);
            }
        }else{
            processNums(list, nums, loc+1, nums[loc], start);
        }
    }
}
