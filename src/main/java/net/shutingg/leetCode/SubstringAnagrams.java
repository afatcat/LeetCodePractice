package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/substring-anagrams/
 */
public class SubstringAnagrams {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }

        char[] pc = p.toCharArray();
        int n = s.length();
        int l = pc.length;
        int[] hash = new int[256];
        for (int i = 0; i < l; i++) {
            hash[pc[i]]++;
        }

        char[] sc = s.toCharArray();
        for (int i = 0; i <= n - l; i++) {
            if (hash[sc[i]] > 0) {
                int[] compHash = new int[256];
                for (int j = i; j < i + l; j++) {
                    compHash[sc[j]]++;
                }
                if (Arrays.equals(hash, compHash)) {
                    res.add(i);
                }
            }
        }

        return res;
    }
}
