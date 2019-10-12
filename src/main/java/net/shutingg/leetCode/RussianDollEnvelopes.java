package net.shutingg.leetCode;

import java.util.Arrays;

public class RussianDollEnvelopes {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // b[i]: index: count; value: largest envelope size
        if (envelopes == null) {
            return 0;
        }
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        Envelope[] list = new Envelope[n];
        for (int i = 0; i < n; i++) {
            Envelope env = new Envelope(envelopes[i][0], envelopes[i][1]);
            list[i] = env;
        }
        Arrays.sort(list, (a, b) -> {
            if (a.length == b.length) {
                return b.width - a.width;
            }
            return a.length - b.length;
        });

        Envelope[] b = new Envelope[n + 1];
        b[0] = new Envelope(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = maxCount;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (isSmaller(b[mid], list[i])) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (isSmaller(b[end], list[i])) {
                if (end + 1 > maxCount) {
                    maxCount = end + 1;
                }
                b[end + 1] = list[i];
            } else {
                if (start + 1 > maxCount) {
                    maxCount = start + 1;
                }
                b[start + 1] = list[i];
            }
        }
        return maxCount;
    }

    private boolean isSmaller(Envelope e1, Envelope e2) {
        if (e1.length < e2.length && e1.width < e2.width) {
            return true;
        }
        return false;
    }

    class Envelope {
        int length;
        int width;
        Envelope(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }
}