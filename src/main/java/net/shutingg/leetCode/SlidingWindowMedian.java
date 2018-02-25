package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    /**
     * PriorityQueue
     *
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
        int midCount;

        MidQueue (int k) {
            maxQueue = new PriorityQueue<>(k, (a, b) -> b - a);
            minQueue = new PriorityQueue<>();
            midCount = (k + 1)/2;
        }

        void add(int num) {
            if (maxQueue.size() < midCount) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }

            if (maxQueue.size() == midCount && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                int large = maxQueue.poll();
                int small = minQueue.poll();
                maxQueue.offer(small);
                minQueue.offer(large);
            }
        }

        void remove(int num) {
            if (num > maxQueue.peek()) {
                minQueue.remove(num);
            } else {
                maxQueue.remove(num);
            }
        }

        int getMid() {
            return maxQueue.peek();
        }
    }
}
