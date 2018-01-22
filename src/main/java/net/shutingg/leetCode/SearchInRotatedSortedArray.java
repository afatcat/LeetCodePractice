package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    /**
     * Binary Search
     * @param nums: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length;
        int st = 0;
        int end = n - 1;
        int p = st + (end - st) / 2;

        while(st + 1 < end){
            if(nums[p] == target){
                return p;
            }

            if(nums[p] < target){
                if(nums[p] > nums[st]){
                    st = p;
                    p = st + (end - st) / 2;
                }else if(nums[st] > target){
                    st = p;
                    p = st + (end - st) / 2;
                }else{
                    end = p;
                    p = st + (end - st) / 2;
                }
            }else{
                if(nums[p] < nums[st]){
                    end = p;
                    p = st + (end - st) / 2;
                }else if(nums[st] > target){
                    st = p;
                    p = st + (end - st) / 2;
                }else{
                    end = p;
                    p = st + (end - st) / 2;
                }
            }
        }

        if(nums[st] == target){
            return st;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}
