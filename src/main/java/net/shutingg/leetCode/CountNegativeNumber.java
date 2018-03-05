package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/count-negative-number/
 */
public class CountNegativeNumber {
    /**
     * Binary Search
     *
     * @param nums: the sorted matrix
     * @return: the number of Negative Number
     */
    public int countNumber(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length ==0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int st = 0;
            int end = nums[0].length - 1;
            int p = (st + end) / 2;
            while (st + 1 < end) {
                if (nums[i][p] < 0) {
                    st = p;
                } else {
                    end = p;
                }
                p = (st + end) / 2;
            }

            if (nums[i][end] < 0) {
                count += end + 1;
            } else if (nums[i][st] < 0){
                count += st + 1;
            }
        }

        return count;
    }
}
