package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/find-peak-element/description/
 * http://www.lintcode.com/en/problem/find-peak-element/
 */
public class FindPeakElement {
    /**
     * Binary Search
     * LeetCode Version
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if(nums == null){
            return -1;
        }
        int st = 0;
        int end = nums.length - 1;
        int p = (st + end) / 2;
        while(st < end){
            if(p < nums.length-1 && nums[p] < nums[p + 1]){
                st = p + 1;
                p = (st + end) / 2;
            }else if(p > 0 && nums[p] < nums[p-1]){
                end = p - 1;
                p = (st + end) / 2;
            }else{
                return p;
            }
        }

        return p;
    }

    /**
     * Binary Search
     * LintCode Version
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if(A == null || A.length < 3){
            return -1;
        }
        int st = 0;
        int end = A.length - 1;
        int p = (st + end) / 2;
        while(st < end){
            if(A[p] < A[p + 1]){
                st = p + 1;
                p = (st + end) / 2;
            }else if(A[p] < A[p-1]){
                end = p - 1;
                p = (st + end) / 2;
            }else{
                return p;
            }
        }

        return p;
    }
}
