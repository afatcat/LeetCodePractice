package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    /**
     * PriorityQueue
     * - It will time out.
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || k <= 0 || nums.length < k) {
            return res;
        }

        MidQueue midQueue = new MidQueue(k);
        for (int i = 0; i < k; i++) {
            midQueue.add(nums[i]);
        }

        res.add(midQueue.getMid());
        for (int i = k; i < nums.length; i++) {
            midQueue.remove(nums[i-k]);
            midQueue.add(nums[i]);
            res.add(midQueue.getMid());
        }
        return res;
    }

    class MidQueue {
        PriorityQueue<Integer> maxQueue;
        PriorityQueue<Integer> minQueue;

        MidQueue (int k) {
            maxQueue = new PriorityQueue<>(k, (a, b) -> b - a);
            minQueue = new PriorityQueue<>();
        }

        void add(int num) {
            if (maxQueue.isEmpty()) {
                maxQueue.add(num);
                return;
            }
            int mid = maxQueue.peek();
            if (num > mid) {
                minQueue.offer(num);
                balance();
            } else {
                maxQueue.offer(num);
                balance();
            }
        }

        void balance() {
            if (minQueue.size() > maxQueue.size()) {
                maxQueue.offer(minQueue.poll());
            } else if (maxQueue.size() > minQueue.size() + 1) {
                minQueue.offer(maxQueue.poll());
            }
        }

        void remove(int num) {
            if (num > maxQueue.peek()) {
                minQueue.remove(num);
            } else {
                maxQueue.remove(num);
            }
            balance();
        }

        int getMid() {
            return maxQueue.peek();
        }
    }
}
