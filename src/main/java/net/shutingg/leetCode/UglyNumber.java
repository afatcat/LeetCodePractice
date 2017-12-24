package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/ugly-number/description/
 */
public class UglyNumber {
    /**
     * Loop
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if(num < 1){
            return false;
        }

        for(int i = 5; i >= 2; i--){
            while(num % i == 0){
                num = num / i;
            }
        }

        return num == 1;
    }
}
