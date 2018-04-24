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

        int min = nums[0];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < nums.length; i++) {
            if (stack.isEmpty()) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > min) {
                    stack.push(nums[i]);
                }
            } else {
                if (nums[i] > stack.peek()) {
                    return true;
                }
                if (nums[i] < stack.peek()) {
                    if (nums[i] < min) {
                        min = nums[i];
                    }
                    if (nums[i] > min) {
                        stack.pop();
                        stack.push(nums[i]);
                    }
                }
            }
        }

        return false;
    }
}
