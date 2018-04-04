package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/next-permutation-ii/
 */
public class NextPermutationII {
    /**
     * Permutation
     *
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swapItem(nums, i, j);
                        flipList(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }

        flipList(nums, 0, nums.length - 1);
    }

    private void swapItem(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void flipList(int[] nums, int i , int j) {
        if (i >= j) {
            return;
        }
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
