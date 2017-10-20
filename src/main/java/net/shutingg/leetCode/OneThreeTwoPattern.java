package net.shutingg.leetCode;

/**
 * Created by sguan on 10/19/17.
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3){
            return false;
        }
        int numLeft = nums[0];
        Integer numMiddle = null;
        for(int i=1;i<nums.length;i++){
            if(numMiddle == null && numLeft<nums[i]){
                numMiddle = nums[i];
            }else if(numMiddle == null && numLeft>nums[i]){
                numLeft = nums[i];
            }else if(numMiddle != null && numMiddle<nums[i]){
                numMiddle = nums[i];
            }else if(numMiddle != null && numMiddle > nums[i]){
                return true;
            }
        }
        return false;
    }
}
