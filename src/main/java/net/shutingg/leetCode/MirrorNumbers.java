package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

public class MirrorNumbers {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }

        char[] cs = num.toCharArray();
        int n = cs.length;
        if (n == 0) {
            return false;
        }

        Map<Character, Character> mirrors = new HashMap<>();
        mirrors.put('6', '9');
        mirrors.put('9', '6');
        mirrors.put('8', '8');
        mirrors.put('1', '1');
        mirrors.put('0', '0');

        int st = 0;
        int end = n - 1;
        while (st <= end) {
            if (!mirrors.containsKey(cs[st]) || mirrors.get(cs[st]) != cs[end]) {
                return false;
            }
            st++;
            end--;
        }

        return true;
    }
}
