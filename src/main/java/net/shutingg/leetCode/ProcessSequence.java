package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/process-sequence/
 */
public class ProcessSequence {
    /**
     * Sweep Line
     * O(n log n + k * n)
     *
     * @param logs: Sequence of processes
     * @param queries: Sequence of queries
     * @return: Return the number of processes
     */
    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        List<Pack> list = new ArrayList<>();
        for (Interval log : logs) {
            Pack start = new Pack(log.start, 1);
            list.add(start);
            Pack end = new Pack(log.end, -1);
            list.add(end);
        }

        Collections.sort(list, (a, b) -> a.index - b.index);
        List<Integer> results = new ArrayList<>();
        for (Integer q : queries) {
            int count = 0;
            for (Pack pack : list) {
                if (pack.index > q) {
                    break;
                }
                count += pack.val;
            }
            results.add(count);
        }

        return results;
    }

    class Pack {
        int index;
        int val;

        Pack(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
