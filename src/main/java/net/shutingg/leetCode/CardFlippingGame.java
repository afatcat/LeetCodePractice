package net.shutingg.leetCode;

/**
 * https://leetcode.com/contest/weekly-contest-81/problems/card-flipping-game/
 *
 * On a table are N cards, with a positive integer printed on the front and back of each card (possibly different).

 We flip any number of cards, and after we choose one card.

 If the number X on the back of the chosen card is not on the front of any card, then this number X is good.

 What is the smallest number that is good?  If no number is good, output 0.

 Here, fronts[i] and backs[i] represent the number on the front and back of card i.

 A flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.

 Example:

 Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
 Output: 2
 Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
 We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.

 Note:

 1 <= fronts.length == backs.length <= 1000.
 1 <= fronts[i] <= 2000.
 1 <= backs[i] <= 2000.
 */
public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        if (fronts == null || backs == null || fronts.length != backs.length || fronts.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                continue;
            }
            if (fronts[i] < res) {
                if (!frontAndBackHas(fronts, backs, fronts[i], i)) {
                    res = fronts[i];
                }
            }
            if (backs[i] < res) {
                if (!frontAndBackHas(fronts, backs, backs[i], i)) {
                    res = backs[i];
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }

        return res;
    }

    private boolean frontAndBackHas(int[] fronts, int[] backs, int target, int skip) {
        for (int i = 0; i < fronts.length; i++) {
            if (i == skip) {
                continue;
            }
            if (fronts[i] == target && backs[i] == target) {
                return true;
            }
        }

        return false;
    }
}
