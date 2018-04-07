package net.shutingg.leetCode;

public class PalindromeDataStream {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        if (s == null || s.length() == 0) {
            return new int[0];
        }

        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] res = new int[n];
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            hash[cs[i] - 'a']++;
            int countOdd = 0;
            for (int j = 0; j < 26; j++) {
                if (hash[j] % 2 == 1) {
                    countOdd++;
                }
            }
            if (countOdd > 1) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }

        return res;
    }
}
