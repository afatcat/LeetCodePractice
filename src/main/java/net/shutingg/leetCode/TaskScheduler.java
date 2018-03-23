package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 */
public class TaskScheduler {
    /**
     * Priority Queue
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(tasks.length + n, (a, b) -> b - a);
        for (Character c : map.keySet()) {
            pq.offer(map.get(c));
        }

        int count = 0;
        int sleep = 0;
        List<Integer> waitList = new ArrayList<>();
        while (!pq.isEmpty() || waitList.size() > 0) {
            if (!pq.isEmpty()) {
                int time = pq.poll();
                time--;
                if (time > 0) {
                    if (n == 0) {
                        pq.offer(time);
                    } else {
                        waitList.add(time);
                    }
                }
            }
            if (sleep > 0) {
                sleep--;
                if (sleep == 0) {
                    pq.addAll(waitList);
                    waitList = new ArrayList<>();
                }
            } else {
                sleep = n;
            }
            count++;
        }

        return count;
    }
}
