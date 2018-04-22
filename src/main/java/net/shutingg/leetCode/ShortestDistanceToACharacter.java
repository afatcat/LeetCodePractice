package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-81/problems/shortest-distance-to-a-character/
 *
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

 Example 1:

 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


 Note:

 S string length is in [1, 10000].
 C is a single character, and guaranteed to be in string S.
 All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) {
            return new int[0];
        }

        Queue<Integer> queue = new LinkedList<>();
        char[] cs = S.toCharArray();
        int n = cs.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (cs[i] == C) {
                queue.offer(i);
                result[i] = 0;
            } else {
                result[i] = Integer.MAX_VALUE;
            }
        }

        int[] dx = {-1, 1};

        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nx = index + dx[i];
                if (nx < 0 || nx >= n || result[nx] <= result[index] + 1) {
                    continue;
                }
                result[nx] = result[index] + 1;
                queue.offer(nx);
            }
        }

        return result;
    }
}
