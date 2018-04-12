package net.shutingg.leetCode;

public class MonotoneIncreasingDigits {
    /**
     * @param num: a non-negative integer N
     * @return: the largest number that is less than or equal to N with monotone increasing digits.
     */
    public int monotoneDigits(int num) {
        if (num <= 9) {
            return num;
        }

        String str = String.valueOf(num);
        char[] cs = str.toCharArray();
        int n = cs.length;
        int i = n - 2;
        int mark = n - 1;
        while (i >= 0) {
            if (cs[i + 1] >= cs[i]) {
                i--;
            } else {
                cs[i]--;
                mark = i;
                i--;
            }
        }

        for (int j = mark + 1; j < n; j++) {
            cs[j] = '9';
        }


        return Integer.valueOf(new String(cs));
    }
}
