package net.shutingg.leetCode;

public class GuessNumberGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        if (n < 1) {
            return 0;
        }

        int st = 1;
        int end = n;
        while (st + 1 < end) {
            int mid = (end - st) / 2 + st;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                st = mid;
            } else {
                end = mid;
            }
        }
        if (guess(end) == 0) {
            return end;
        }
        return st;
    }

    //dummy method
    int guess(int n) {
        return 0;
    }
}
