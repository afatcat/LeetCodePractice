package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/count-and-say/description/
 * http://www.lintcode.com/en/problem/count-and-say/
 */
public class CountAndSay {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 1; i < n; i++) {
            char[] old = sb.toString().toCharArray();
            sb = new StringBuilder();
            char last = old[0];
            int count = 1;
            for (int j = 1; j < old.length; j++) {
                if (old[j] != last) {
                    sb.append("" + count + last);
                    last = old[j];
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append("" + count + last);
        }

        return sb.toString();
    }
}
