package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/minimum-cycle-section/
 *
 * Given an array of int, find the length of the minimum cycle section.

 Notice

 The length of array do not exceed 100000。
 Each element is in the int range 。

 Example
 Given array = [1,2,1,2,1,2], return 2.

 Explanation:
 The minimum cycle section is [1,2]，and the length is 2.
 Given array = [1,2,1,2,1], return 2.

 Explanation:
 The minimum cycle section is [1,2]，and the length is 2, although the last 2 is not given, we still consider the cycle section is [1,2].
 Given array = [1,2,1,2,1,4], return 6.

 Explanation:
 The minimum cycle section is [1,2,1,2,1,4], and the length is 6.
 */
public class MinimumCycleSection {
    /**
     * Two Pointers
     *
     * @param array: an integer array
     * @return: the length of the minimum cycle section
     */
    public int minimumCycleSection(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int i = 0, l = 1, j = 1;
        while (j < array.length) {
            if (array[i] == array[j]) {
                i++;
                j++;
            } else {
                i = 0;
                l++;
                j = l;
            }
        }

        return j - i;
    }
}
