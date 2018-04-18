package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/time-intersection/
 */
public class TimeIntersection {
    /**
     * Sweep line
     * O(n log n)
     *
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        List<Interval> res = new ArrayList<>();
        if (seqA == null || seqB == null || seqA.size() == 0 || seqB.size() == 0) {
            return res;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(seqA.size() * 2 + seqB.size() * 2, (a, b) -> {
            if (a.time == b.time) {
                return a.flag - b.flag;
            } else {
                return a.time - b.time;
            }
        });

        for (Interval interval : seqA) {
            pq.offer(new Point(interval.start, 1));
            pq.offer(new Point(interval.end, -1));
        }
        for (Interval interval : seqB) {
            pq.offer(new Point(interval.start, 1));
            pq.offer(new Point(interval.end, -1));
        }

        int count = 0;
        int st = -1;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            count = count + p.flag;
            if (count == 2) {
                st = p.time;
            } else {
                if (st != -1) {
                    if (count == 1) {
                        res.add(new Interval(st, p.time));
                    } else {
                        st = -1;
                    }

                }
            }
        }

        return res;
    }

    class Point {
        int time;
        int flag;
        Point (int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
