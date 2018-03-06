package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/folding-array/
 */
public class FoldingArray {
    /**
     * @param nums: the original array
     * @param req: the direction each time
     * @return: the final folded array
     */
    public int[] folding(int[] nums, int[] req) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < req.length; i++) {
            fold(nums, i, req[i]);
        }

        return nums;
    }

    private void fold(int[] nums, int loc, int direction) {
        int n = nums.length;
        int l = n;
        for (int i = 0; i < loc + 1; i++) {
            l = l / 2;
        }
        if (direction == 0) {
            shuffle(nums, l, false);
        } else {
            shuffle(nums, l, true);
        }
    }

    private void shuffle(int[] nums, int l, boolean toStack) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % l == 0) {
                toStack = !toStack;
            }
            if (toStack) {
                stack.push(nums[i]);
            } else {
                queue.offer(nums[i]);
            }
        }
        int i = 0;
        while (!stack.isEmpty()) {
            nums[i] = stack.pop();
            i++;
        }
        while (!queue.isEmpty()) {
            nums[i] = queue.poll();
            i++;
        }
    }
}
