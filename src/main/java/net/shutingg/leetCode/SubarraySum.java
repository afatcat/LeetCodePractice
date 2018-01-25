package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/subarray-sum/
 */
public class SubarraySum {
    /**
     * DP - coordinate + Rolling Array
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // f[i][j] = f[i][j-1] + nums[j]
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if(n == 0) {
            return list;
        }
        int[] f = new int[n];
        for(int i = 0; i < n; i++){
            if (nums[i] == 0){
                list.add(i);
                list.add(i);
                return list;
            }
        }
        for(int i = 0; i < n; i++){
            f[i] = nums[i];
            for(int j = i + 1; j < n; j++){
                f[j] = f[j-1] + nums[j];
                if(f[j] == 0) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return null;
    }
}
