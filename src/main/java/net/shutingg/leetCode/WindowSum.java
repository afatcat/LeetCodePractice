package net.shutingg.leetCode;

import java.util.stream.IntStream;

public class WindowSum {
    /**
     * Array
     *
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        if (nums.length < k) {
            int sum = IntStream.of(nums).sum(); //int sum = Arrays.stream(nums).sum();
            return new int[]{sum};
        }

        int[] sums = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sums[0] = sum;
        for (int i = k; i < nums.length; i++) {
            sums[i - k + 1] = sums[i - k] - nums[i - k] + nums[i];
        }

        return sums;
    }
}
