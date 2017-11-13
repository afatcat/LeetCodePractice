package net.shutingg.leetCode;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int tmp = digits[i] + carry;
            carry = tmp/10;
            result[i+1] = tmp%10;
        }
        if(carry == 0){
            return Arrays.copyOfRange(result, 1, result.length);
        }else{
            result[0] = carry;
            return result;
        }
    }
}
