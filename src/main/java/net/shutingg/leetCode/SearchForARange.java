package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/search-for-a-range/description/
 * http://www.lintcode.com/en/problem/search-for-a-range/
 */
public class SearchForARange {
    /**
     * Binary Search
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int n = A.length;
        if(n == 0){
            return new int[]{-1, -1};
        }
        int st = 0;
        int end = n-1;
        int p = st + (end - st) / 2;
        int[] range = new int[2];

        while(st + 1 < end){
            if(A[p] == target){
                end = p;
                p = st + (end - st) / 2;
            }else if(A[p] > target){
                end = p;
                p = st + (end - st) / 2;
            }else{
                st = p;
                p = st + (end - st) / 2;
            }
        }

        if(A[st] == target){
            range[0] = st;
        }else if(A[end] == target){
            range[0] = end;
        }else{
            return new int[]{-1, -1};
        }

        st = 0;
        end = n - 1;
        p = st + (end - st) / 2;

        while(st + 1 < end){
            if(A[p] == target){
                st = p;
                p = st + (end - st) / 2;
            }else if(A[p] > target){
                end = p;
                p = st + (end - st) / 2;
            }else{
                st = p;
                p = st + (end - st) / 2;
            }
        }

        if(A[end] == target){
            range[1] = end;
        }else{
            range[1] = st;
        }

        return range;
    }
}
