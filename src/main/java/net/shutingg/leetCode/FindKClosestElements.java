package net.shutingg.leetCode;

public class FindKClosestElements {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k == 0) {
            return new int[0];
        }

        int st = 0;
        int end = A.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (A[pl] > target) {
                end = pl;
            } else if (A[pl] < target) {
                st = pl;
            } else {
                st = pl;
                end = pl;
            }
        }

        int n = k <= A.length ? k : A.length;
        int[] res = new int[n];
        int i = 0;
        int first = findNearer(st, end, A, target);
        res[0] = A[first];
        i++;
        int left = first - 1;
        int right = first + 1;

        while (i < n) {
            int next = findNearer(left, right, A, target);
            res[i] = A[next];
            if (next == left) {
                left--;
            } else {
                right++;
            }
            i++;
        }
        return res;
    }

    private int findNearer(int left, int right, int[] A, int target) {
        if (left < 0) {
            return right;
        }
        if (right >= A.length) {
            return left;
        }

        if (A[right] - target < target - A[left]) {
            return right;
        }

        return left;
    }
}
