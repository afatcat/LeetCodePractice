package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Two Pointers
     * Careful the previous numbers could have been modified
     *
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (j + 2 >= n || nums[j] != nums[j + 2]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}
