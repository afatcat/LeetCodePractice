package net.shutingg.leetCode;

import java.util.*;

/**
 * Weekly Mock Interview Contest #13 (For Netflix Onsite)
 * http://www.lintcode.com/en/problem/big-business/
 *
 * Given two arrays a and b. a[i] stands for the royalties of the film i, b[i] represents the money that the movie i can sell, now we have principal k, find how much money can be earned in the end.(Each movie only needs to be bought once and can only be sold once.)

 Notice

 All the input does not exceed 100000
 The size of array does not exceed 10000.

 Example
 Given a = [3,1,5], b = [4,3,100], k = 1，return 4.

 Explanation:
 Buy the second video first, then sell it, buy the first video, sell it again, and finally the principal becomes 4.
 Given a = [3,1,5], b = [4,3,100], k = 10，return 108。

 Explanation:
 Buy all the videos, sell them, and finally the principal becomes 108.
 */
public class BigBusiness {
    /**
     * @param a: The cost of the film
     * @param b: The price of the selling of the film
     * @param k: The principal
     * @return: The answer
     */
    public int bigBusiness(int[] a, int[] b, int k) {
        if (a == null || b == null || a.length != b.length || k <= 0 || a.length == 0) {
            return 0;
        }

        int n = a.length;
        List<Comp> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int diff = b[i] - a[i];
            if (diff > 0) {
                Comp comp = new Comp(a[i], b[i], diff);
                list.add(comp);
            }
        }

        Collections.sort(list, (x, y) -> x.cost - y.cost);
        int sum = k;
        int fund = k;
        for (Comp comp : list) {
            if (comp.cost > fund) {
                break;
            }
            fund = fund + comp.diff;
            sum = sum + comp.diff;
        }
        return sum;
    }

    class Comp {
        int cost;
        int price;
        int diff;
        Comp(int cost, int price, int diff) {
            this.cost = cost;
            this.price = price;
            this.diff = diff;
        }
    }
}
