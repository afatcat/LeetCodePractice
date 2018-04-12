package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-right-interval/description/
 */
public class FindRightInterval {
    /**
     * Binary Search
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }

        Map<Interval, Integer> locations = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            locations.put(intervals[i], i);
        }

        Interval[] sortedInterval = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sortedInterval, (a, b) -> a.start - b.start);
        int[] results = new int[intervals.length];
        for (int i = 0; i < results.length; i++) {
            Interval first = findFirstStart(sortedInterval, intervals[i].end);
            if (first == null) {
                results[i] = -1;
            } else {
                results[i] = locations.get(first);
            }
        }

        return results;
    }

    private Interval findFirstStart(Interval[] intervals, int target) {
        int st = 0;
        int end = intervals.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (intervals[pl].start >= target) {
                end = pl;
            } else {
                st = pl;
            }
        }
        if (intervals[st].start >= target) {
            return intervals[st];
        }
        if (intervals[end].start >= target) {
            return intervals[end];
        }

        return null;
    }
}
