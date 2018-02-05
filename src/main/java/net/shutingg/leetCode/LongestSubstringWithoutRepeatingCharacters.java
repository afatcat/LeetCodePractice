package net.shutingg.leetCode;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Window Pointers
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        int[] map = new int[256]; //ascii
        char[] cs = s.toCharArray();
        int result = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && map[cs[j]] == 0) {
                map[cs[j]] = 1;
                j++;
            }
            result = Math.max(result, j - i);

            //reached the end
            if (j == n) {
                break;
            }

            map[cs[i]] = 0;
        }
        return result;
    }
}
