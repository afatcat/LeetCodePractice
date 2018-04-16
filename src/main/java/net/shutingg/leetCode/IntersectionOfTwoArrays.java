package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    /**
     * Hash
     *
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        int[] res = new int[resultSet.size()];
        int k = 0;
        for (Integer i : resultSet) {
            res[k] = i;
            k++;
        }

        return res;
    }
}
