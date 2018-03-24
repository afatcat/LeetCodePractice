package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/kth-smallest-numbers-in-unsorted-array/
 */
public class KthSmallestNumbersInUnsortedArray {
    /**
     * PriorityQueue
     *
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length < k || k <= 0) {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }
}
