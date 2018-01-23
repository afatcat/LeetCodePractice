package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/search-insert-position/
 */
public class SearchInsertPosition {
    /**
     * Binary Search
     * - Find first larger than or equal to target
     * - Or find last smaller than target + 1
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int st = 0;
        int end = n - 1;
        int p = st + (end - st) / 2;

        while (st < end){
            if (A[p] == target){
                return p;
            } else if (A[p] < target) {
                st = p + 1;
                p = st + (end - st) / 2;
            } else {
                end = p;
                p = st + (end - st) / 2;
            }
        }

        if(A[p] < target){
            return p + 1;
        }

        return p;
    }
}
