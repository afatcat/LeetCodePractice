package net.shutingg.leetCode;

public class MedianOfKSortedArrays {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0.0;
        }

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length > 0) {
                start = Math.min(start, nums[i][0]);
                end = Math.max(end, nums[i][nums[i].length - 1]);
                count += nums[i].length;
            }
        }

        if (count == 0) {
            return 0;
        }

        if ((count & 1) == 1) {
            return findKth(nums, (count + 1) / 2, start, end);
        }

        return (findKth(nums, count / 2, start, end) + findKth(nums, count / 2 + 1, start, end)) / 2.0;
    }

    int findKth(int[][] nums, int k, int st, int end) {
        while (st + 1 < end) {
            int pivot = (end - st) / 2 + st;
            int count = countAllSE(nums, pivot);
            if (count < k) {
                st = pivot;
            } else {
                end = pivot;
            }
        }

        if (countAllSE(nums, st) == k) {
            return st;
        }
        return end;
    }

    int countAllSE(int[][] nums, int pivot) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += countSE(nums[i], pivot);
        }

        return count;
    }

    int countSE(int[] row, int pivot) {
        if (row == null || row.length == 0) {
            return 0;
        }
        int st = 0;
        int end = row.length - 1;
        while (st + 1 < end) {
            int mid = (end - st) / 2 + st;
            if (row[mid] <= pivot) {
                st = mid;
            } else {
                end = mid;
            }
        }
        if (row[end] <= pivot) {
            return end + 1;
        }
        if (row[st] <= pivot) {
            return st + 1;
        }

        return 0;
    }
}
