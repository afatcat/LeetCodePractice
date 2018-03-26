package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/two-sum-data-structure-design/
 *
 * 2Sum - HashMap
 */
public class TwoSumDataStructureDesign {
    Map<Integer, Integer> hashMap = new HashMap<>();
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer key : hashMap.keySet()) {
            int num2 = value - key;
            if (key == num2) {
                if (hashMap.get(key) > 1) {
                    return true;
                }
            } else {
                if (hashMap.containsKey(num2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
