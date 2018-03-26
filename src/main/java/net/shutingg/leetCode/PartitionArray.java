package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/partition-array/
 * Part of Quick Sort
 */
public class PartitionArray {
    /**
     * Two pointers
     *
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] < k) {
                i++;
            }

            while (j > i && nums[j] >= k) {
                j--;
            }

            if (i < j) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j--;
            }
        }

        if (nums[i] < k) {
            return i + 1;
        }

        return i;
    }
}
