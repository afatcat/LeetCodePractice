package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/identify-celebrity/
 */
public class IdentifyCelebrity {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        if (n <= 0) {
            return -1;
        }

        int i = 0;
        while (i < n) {
            int j = 0;
            while (j < n) {
                if (j == i) {
                    j++;
                } else if (knows(j, i)) {
                    if (knows(i, j)) {
                        i++;
                        break;
                    }
                    j++;
                } else {
                    i++;
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    private boolean knows(int a, int b) {
        //dummy
        return false;
    }
}
