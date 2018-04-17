package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/merge-k-sorted-interval-lists/
 */
public class MergeKSortedIntervalLists {
    /**
     * PriorityQueue
     *
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        List<Interval> results = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return results;
        }

        Queue<Pack> pq = new PriorityQueue<>(intervals.size(), (a, b) ->
                a.interval.start - b.interval.start
        );
        for (int i = 0; i < intervals.size(); i++) {
            List<Interval> list = intervals.get(i);
            if (list != null && list.size() > 0) {
                pq.offer(new Pack(list.get(0), i, 0));
            }
        }

        Interval current = null;
        while (!pq.isEmpty()) {
            Pack pack = pq.poll();
            if (current == null) {
                current = pack.interval;
                updatePackIntoQ(intervals, pack, pq);
            } else {
                if (current.end < pack.interval.start) {
                    results.add(current);
                    current = pack.interval;
                    updatePackIntoQ(intervals, pack, pq);
                } else {
                    if (current.end < pack.interval.end) {
                        current.end = pack.interval.end;
                    }
                    updatePackIntoQ(intervals, pack, pq);
                }
            }
        }
        if (current != null) {
            results.add(current);
        }

        return results;
    }

    void updatePackIntoQ(List<List<Interval>> intervals, Pack pack, Queue pq) {
        if (intervals.get(pack.row).size() > pack.col + 1) {
            pack.interval = intervals.get(pack.row).get(pack.col + 1);
            pack.col++;
            pq.offer(pack);
        }
    }

    class Pack {
        Interval interval;
        int row;
        int col;
        Pack(Interval interval, int row, int col) {
            this.interval = interval;
            this.row = row;
            this.col = col;
        }
    }
}
