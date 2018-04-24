package net.shutingg.leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (Integer i : nums) {
            if (i <= small) {
                small = i;
            } else if (i <= big) {
                big = i;
            } else {
                return true;
            }
        }

        return false;
    }
}
