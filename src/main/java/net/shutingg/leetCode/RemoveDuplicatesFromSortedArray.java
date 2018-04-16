package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Two pointers
     *
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (j > 0 && j < nums.length && nums[j] == nums[j - 1]) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }
}
