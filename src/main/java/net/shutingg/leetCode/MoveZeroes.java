package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/move-zeroes/
 */
public class MoveZeroes {
    /**
     * Two pointers - same direction
     *
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
    }
}
