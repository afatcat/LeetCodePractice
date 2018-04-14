package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/deliver-the-message/
 *
 * Given the information of a company's personnel. The time spent by the ith person passing the message is t[i] and the list of subordinates is list[i]. When someone receives a message, he will immediately pass it on to all his subordinates. Person numbered 0 is the CEO. Now that the CEO has posted a message, find how much time it takes for everyone in the company to receive the message?
 *
 * Notice

 The number of employees is n，n <= 1000.
 Everyone can have multiple subordinates but only one superior.
 Time t[i] <= 10000。
 -1 represent no subordinates.

 Example
 Given t = [1,2,3], list = [[1,2],[-1],[-1]], return 1.

 Explanation:
 The news was passed from the CEO, and the time passed to No. 1 and No. 2 was 1. At this time, all the people in the company received the news.
 Given t = [1,2,1,4,5], list = [[1,2],[3,4],[-1],[-1],[-1]], return 3.

 Explanation:
 The message was passed from the CEO. The time passed to the No. 1 and No. 2 characters was 1, the time passed to the No. 3 character was 3, and the message passed through 2 to 4 was faster than passing through 1  so the time which is costed for passing to 4 was 2. Finally at the time of 3, everyone received the news.
 */
public class DeliverTheMessage {
    /**
     * @param t: the time of each employee to pass a meeage
     * @param subordinate: the subordinate of each employee
     * @return: the time of the last staff recieve the message
     */
    public int deliverMessage(int[] t, int[][] subordinate) {
        if (t == null || subordinate == null || subordinate.length != t.length || t.length == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> times = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(0);
        times.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int time = times.poll();
            if (map.containsKey(index) && map.get(index) < time) {
                continue;
            }
            map.put(index, time);
            for (int i = 0; i < subordinate[index].length; i++) {
                if (subordinate[index][i] == -1) {
                    continue;
                }
                int next = subordinate[index][i];
                queue.offer(next);
                times.offer(time + t[index]);
            }
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(map.get(key), max);
        }

        return max;
    }
}
