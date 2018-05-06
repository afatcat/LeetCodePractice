package net.shutingg.leetCode;

/**
 * https://leetcode.com/contest/weekly-contest-83/problems/consecutive-numbers-sum/
 *
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

 Example 1:

 Input: 5
 Output: 2
 Explanation: 5 = 5 = 2 + 3
 Example 2:

 Input: 9
 Output: 3
 Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 Example 3:

 Input: 15
 Output: 4
 Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 Note: 1 <= N <= 10 ^ 9.
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        int div = 1;
        while (div % 2 == 1 && N / div - 1 >= div / 2 || div % 2 == 0 && N / div >= div / 2) {
            if (div % 2 == 1) {
                if (N % div == 0) {
                    if (N / div - 1 >= div / 2) {
                        count++;
                    } else {
                        break;
                    }
                }
            } else {
                if (N % div == div / 2) {
                    if (N / div >= div / 2) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            div++;
        }

        return count;
    }
}
