package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        if(nums==null || nums.length<1) return null;
        Map<Integer, Integer> places = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            places.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] results = new String[nums.length];
        results[places.get(nums[nums.length-1])]="Gold Medal";
        if(nums.length<2) return results;
        results[places.get(nums[nums.length-2])]="Silver Medal";
        if(nums.length<3) return results;
        results[places.get(nums[nums.length-3])]="Bronze Medal";
        for(int i=nums.length-4; i>=0;i--){
            results[places.get(nums[i])]=nums.length-i+"";
        }
        return results;
    }
}
