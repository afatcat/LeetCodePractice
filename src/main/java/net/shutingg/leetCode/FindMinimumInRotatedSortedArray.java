package net.shutingg.leetCode;

/**
 *
 * http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * Binary Search
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n-1;
        int p = (st + end)/2;

        while(st <= end){
            if(nums[st] <= nums[end]){
                return nums[st];
            }

            if(nums[p] > nums[end]){
                st = p + 1;
                p = (st + end) / 2;
                continue;
            }

            //nums[p] < nums[end]
            end = p;
            p = (st + end) / 2;
        }

        return nums[p];
    }
}
