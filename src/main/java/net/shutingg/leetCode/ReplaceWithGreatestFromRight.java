package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/replace-with-greatest-from-right/
 */
public class ReplaceWithGreatestFromRight {
    /*
     * @param : An array of integers.
     * @return: nothing
     */
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int largest = nums[n - 1];
        nums[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = largest;
            if (tmp > largest) {
                largest = tmp;
            }
        }
    }
}
