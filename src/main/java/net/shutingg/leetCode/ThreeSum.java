package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/3sum/
 */
public class ThreeSum {
    /**
     * Two Pointers
     *
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }

        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (numbers[i] + numbers[j] + numbers[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    res.add(list);
                    j++;
                    k--;

                    while (j < k && numbers[j] == numbers[j - 1]) {
                        j++;
                    }
                    while (k > j && numbers[k] == numbers[k + 1]) {
                        k--;
                    }
                } else if (numbers[i] + numbers[j] + numbers[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}
