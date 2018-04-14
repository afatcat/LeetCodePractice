package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/move-zeroes/
 */
public class MoveZeroes {
    /**
     * Two Pointer - same direction
     * Keep order and minimize write (no swap)
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int i = 0;
        while (i < n && nums[i] != 0) {
            i++;
        }
        int j = i + 1;
        while (j < n) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        while (i < n) {
            nums[i] = 0;
            i++;
        }
    }

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
