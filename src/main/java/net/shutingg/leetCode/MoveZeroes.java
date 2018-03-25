package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/move-zeroes/
 */
public class MoveZeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] == 0) {
            j--;
        }

        int i = j - 1;
        while (i >= 0) {
            if (nums[i] == 0) {
                for (int k = i; k < j; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[j] = 0;
                j--;
            }
            i--;
        }
    }
}
