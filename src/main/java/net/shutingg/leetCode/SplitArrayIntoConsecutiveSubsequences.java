package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 */
public class SplitArrayIntoConsecutiveSubsequences {
    /**
     * Time O(n), Space O(1)
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        //for ;;p1 = c1, p2 = c2, p3 = c3, prev = cur, c1 = 0, c2 = 0, c3 = 0
        //  cur = nums[i], ccount = 1
        //  for ; nums[i] == nums[i - 1]; i++, ccount++
        //    if cur != prev + 1
        //      if p1 > 0 or p2 > 0 return false
        //      else c1 = ccount, c2 = 0
        //    if cur == prev + 1
        //      if ccount < p1 + p2 or ccount < p1 return false
        //      c2 = p1, c3 = p2 + min(p3, ccount - p1 - p2), c1 = max(ccount - p1 - p2 - p3, 0)

        if (nums == null || nums.length < 3) {
            return false;
        }

        int last = 0;
        int p1 = 0, p2 = 0, p3 = 3, c1 = 3, c2 = 0, c3 = 0;
        int cur = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++, p1 = c1, p2 = c2, p3 = c3, prev = cur) {
            cur = nums[i];
            int ccount = 1;
            for (; i + 1 < nums.length && nums[i] == nums[i + 1]; i++) {
                ccount++;
            }

            if (cur != prev + 1) {
                if (p1 > 0 || p2 > 0) {
                    return false;
                }
                c1 = ccount; c2 = 0;
            } else {
                if (ccount < p1 + p2) {
                    return false;
                }
                c2 = p1;
                c3 = p2 + Math.min(p3, ccount - p1 - p2);
                c1 = Math.max(ccount - p1 - p2 - p3, 0);
            }
        }

        return p1 == 0 && p2 == 0;
    }
}
