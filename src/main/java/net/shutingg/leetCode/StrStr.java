package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/strstr/
 */
public class StrStr {
    /**
     * Rabin Karp
     *
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }

        int tHash = computeHash(target);
        int n = target.length();
        int m = source.length();
        if (source.substring(0, n).equals(target)) {
            return 0;
        }
        int sHash = computeHash(source.substring(0, n));
        int mul = 1;
        for (int i = 1; i < n; i++) {
            mul *= 31;
        }
        for (int i = 1; i < m - n + 1; i++) {
            String str = source.substring(i, i + n);
            sHash = (sHash - (source.charAt(i - 1) - 'a')) / 31 + (source.charAt(i + n - 1) - 'a') * mul;
            if (sHash == tHash && str.equals(target)) {
                return i;
            }
        }

        return -1;
    }

    private int computeHash(String str) {
        int hash = 0;
        char[] cs = str.toCharArray();
        int b = 1;
        for (int i = 0; i < cs.length; i++) {
            hash += (cs[i] - 'a') * b;
            b *= 31;
        }
        return hash;
    }
}
