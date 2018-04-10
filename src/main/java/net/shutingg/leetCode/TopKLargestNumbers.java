package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/top-k-largest-numbers/
 */
public class TopKLargestNumbers {
    /**
     * PriorityQueue
     *
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] results = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--) {
            results[i] = pq.poll();
        }

        return results;
    }
}
