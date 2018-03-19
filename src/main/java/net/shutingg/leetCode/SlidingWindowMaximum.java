package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * http://www.lintcode.com/en/problem/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    /**
     * TreeSet
     *
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The maximum number inside the window at each moving
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }

        TreeSet<Point> set = new TreeSet<>((a, b) -> a.val == b.val ? a.loc - b.loc : a.val - b.val);
        for (int i = 0; i < nums.length; i++) {
            set.add(new Point(i, nums[i]));
            if (set.size() == k) {
                res.add(set.last().val);
                set.remove(new Point(i - k + 1, nums[i - k + 1]));
            }
        }

        return res;
    }

    class Point {
        int loc;
        int val;
        Point(int loc, int val) {
            this.loc = loc;
            this.val = val;
        }
    }
}
