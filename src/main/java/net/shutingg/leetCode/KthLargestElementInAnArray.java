package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * Quick Select
 * O(n)
 * https://www.jiuzhang.com/tutorial/algorithm/321
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 1) {
            return -1;
        }

        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int st, int end) {
        if (st == end) {
            return nums[st];
        }
        int i = st;
        int j = end;
        int pivot = nums[(i + j) / 2];
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        if (j + 1 >= k) {
            return quickSelect(nums, k, st, j);
        }
        if (i + 1 <= k) {
            return quickSelect(nums, k, i, end);
        }
        return nums[j + 1];
    }
}
