package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/data-stream-median/
 */
public class DataStreamMedian {
    /**
     * PriorityQueue
     *
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        if (nums.length == 1) {
            res[0] = nums[0];
            return res;
        }

        PriorityQueue<Integer> sQ = new PriorityQueue<>(nums.length / 2, (a, b) -> b - a);
        PriorityQueue<Integer> bQ = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (sQ.isEmpty()) {
                sQ.offer(nums[i]);
            } else if (bQ.isEmpty()) {
                if (sQ.peek() > nums[i]) {
                    int tmp = sQ.poll();
                    bQ.offer(tmp);
                    sQ.offer(nums[i]);
                } else {
                    bQ.offer(nums[i]);
                }
            } else if (sQ.size() == bQ.size()) {
                if (bQ.peek() < nums[i]) {
                    int tmp = bQ.poll();
                    sQ.offer(tmp);
                    bQ.offer(nums[i]);
                } else {
                    sQ.offer(nums[i]);
                }
            } else {
                if (sQ.peek() > nums[i]) {
                    int tmp = sQ.poll();
                    bQ.offer(tmp);
                    sQ.offer(nums[i]);
                } else {
                    bQ.offer(nums[i]);
                }
            }
            res[i] = sQ.peek();
        }

        return res;
    }
}
