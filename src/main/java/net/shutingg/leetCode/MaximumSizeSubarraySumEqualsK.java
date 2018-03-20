package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        int max = 0;
        for (Integer v : map.keySet()) {
            if (k == v) {
                for (Integer i : map.get(v)) {
                    max = Math.max(max, i + 1);
                }
            } else if (map.containsKey(v - k)) {
                for (Integer i : map.get(v)) {
                    for (Integer j : map.get(v - k)) {
                        if (i > j) {
                            max = Math.max(max, i - j);
                        }
                    }
                }
            }
        }

        return max;
    }
}
