package net.shutingg.leetCode;

 import java.util.PriorityQueue;
 import java.util.Queue;

 /**
 * http://lintcode.com/en/problem/kth-smallest-sum-in-two-sorted-arrays/
 */
public class KthSmallestSumInTwoSortedArrays {
    /**
     * PriorityQueue
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            //invalid input
            return Integer.MAX_VALUE;
        }

        int m = A.length;
        int n = B.length;

        Queue<Element> queue = new PriorityQueue<>(k, (a, b) -> a.val - b.val);
        queue.offer(new Element(0, 0, A[0] + B[0]));
        int[][] hash = new int[m][n];
        Element curr = null;
        int[] x = {1, 0};
        int[] y = {0, 1};
        for(int i = 0; i < k - 1; i++) {
            curr = queue.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = curr.aLoc + x[j];
                int nextY = curr.bLoc + y[j];
                if (nextX < m && nextY < n && hash[nextX][nextY] == 0) {
                    hash[nextX][nextY] = 1;
                    queue.offer(new Element(nextX, nextY, A[nextX] + B[nextY]));
                }
            }
        }
        return queue.poll().val;
    }

    private class Element {
        int aLoc;
        int bLoc;
        int val;

        Element (int aLoc, int bLoc, int val) {
            this.aLoc = aLoc;
            this.bLoc = bLoc;
            this.val = val;
        }
    }
}
