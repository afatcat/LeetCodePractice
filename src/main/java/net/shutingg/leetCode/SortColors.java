package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/sort-colors/
 */
public class SortColors {
    /**
     * Two Pointers
     * O(n)
     *
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pl = 0;
        int i = 0;
        int pr = nums.length - 1;
        while (i <= pr) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[pl];
                nums[pl] = tmp;
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[pr];
                nums[pr] = tmp;
                pr--;
            }
        }
    }
}
