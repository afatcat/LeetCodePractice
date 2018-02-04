package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Window Pointers
     * (Map is not needed. Need to be improved)
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        map.put(cs[0], 0);
        int result = 0;
        int j = 1;
        for (int i = 0; i < n; i++) {
            while (j < n && map.get(cs[j]) == null) {
                map.put(cs[j], j);
                j++;
            }

            result = Math.max(result, map.size());
            if (j >= n - 1) {
                break;
            }
            int firstDup = map.get(cs[j]);
            for (int k = i; k <= firstDup; k++) {
                map.remove(cs[k]);
            }
            i = firstDup;
        }
        return result;
    }
}
