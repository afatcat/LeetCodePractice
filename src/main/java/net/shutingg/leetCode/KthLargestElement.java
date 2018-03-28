package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/kth-largest-element/
 */
public class KthLargestElement {
    /**
     * Quick Select
     *
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(k, nums, 0, nums.length - 1);
    }

    private int quickSelect(int k, int[] nums, int st, int end) {
        if (st == end) {
            return nums[st];
        }
        int pivot = nums[(st + end) / 2];
        int i = st;
        int j = end;
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

        if (j >= k - 1) {
            return quickSelect(k, nums, st, j);
        }

        if (i <= k - 1) {
            return quickSelect(k, nums, i, end);
        }

        return nums[j + 1];
    }
}
