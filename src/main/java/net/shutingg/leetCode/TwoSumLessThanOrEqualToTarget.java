package net.shutingg.leetCode;

import java.util.Arrays;

public class TwoSumLessThanOrEqualToTarget {
    /**
     * Brute force
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] <= target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
