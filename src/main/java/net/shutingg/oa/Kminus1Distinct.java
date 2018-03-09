package net.shutingg.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Amazon OA 1
 */
public class Kminus1Distinct {
    int twos = 0;
    int ones = 0;
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsLessKDist(String inputString, int num)
    {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (inputString == null || inputString.length() < num) {
            return res;
        }

        if (num < 2 || num > 26) {
            return res;
        }

        char[] cs = inputString.toCharArray();
        int n = cs.length;
        int[] hash = new int[256];
        for (int i = 0; i < num; i++) {
            hash[cs[i]]++;
        }

        if (isValid(hash, 0, num)) {
            set.add(new String(cs, 0, num));
        }

        for (int i = 1; i + num <= n; i++) {
            if (cs[i + num - 1] != cs[i - 1]) {
                hash[cs[i + num - 1]]++;
                if (hash[cs[i + num - 1]] == 1) {
                    ones++;
                }
                if (hash[cs[i + num - 1]] == 2) {
                    twos++;
                    ones--;
                }
                if (hash[cs[i - 1]] == 1) {
                    ones--;
                }
                if (hash[cs[i - 1]] == 2) {
                    twos--;
                    ones++;
                }
                hash[cs[i - 1]]--;
            }
            if (twos == 1 && twos * 2 + ones == num) {
                set.add(new String(cs, i, num));
            }
        }

        return new ArrayList<>(set);
    }

    private boolean isValid(int[] hash, int st, int length) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 2) {
                twos++;
            } else if(hash[i] == 1) {
                ones++;
            }
        }
        if (twos == 1 && twos * 2 + ones == length) {
            return true;
        } else {
            return false;
        }
    }
    // METHOD SIGNATURE ENDS
}
