package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/two-sum/
 */
public class TwoSum {
    /**
     * Hash
     *
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int otherNum = target - numbers[i];
            if (map.containsKey(otherNum)) {
                int[] result = new int[2];
                result[0] = map.get(otherNum);
                result[1] = i;
                return result;
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[0];
    }


    public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 1){
            return null;
        }
        int[] res = new int[2];
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
}
