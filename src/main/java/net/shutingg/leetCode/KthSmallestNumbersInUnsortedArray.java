package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/kth-smallest-numbers-in-unsorted-array/
 */
public class KthSmallestNumbersInUnsortedArray {
    /**
     * Quick Select
     * O(n)
     *
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest2(int k, int[] nums) {
        if (nums == null || nums.length < k || k <= 0) {
            return Integer.MIN_VALUE;
        }

        return quickSelect(k, nums, 0, nums.length - 1);
    }

    private int quickSelect(int k, int[] nums, int st, int end) {
        if (st == end) {
            return nums[st];
        }

        int pivot = nums[(st + end) / 2];
        int i = st;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        if (j >= k - 1) {
            return quickSelect(k, nums, st, j);
        }
        if (i <= k - 1) {
            return quickSelect(k, nums, i, end);
        }
        return nums[j + 1];
    }


    /**
     * PriorityQueue
     * O(n log n)
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
