package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    /**
     * Sliding Window + Hash
     *
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return "";
        }

        int[] targetHash = buildHash(target);
        int[] sourceHash = new int[256];
        char[] cs = source.toCharArray();
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < source.length(); i++) {
            while (!isValid(sourceHash, targetHash) && j < cs.length) {
                sourceHash[cs[j]]++;
                j++;
            }

            if (!isValid(sourceHash, targetHash)) {
                break;
            }

            if (j - i < minLength) {
                minLength = j - i;
                result = source.substring(i, j);
            }

            sourceHash[cs[i]]--;
        }

        return result;
    }

    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (sourceHash[i] < targetHash[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] buildHash(String s) {
        int[] hash = new int[256];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            hash[cs[i]]++;
        }

        return hash;
    }
}
