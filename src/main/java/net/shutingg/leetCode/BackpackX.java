package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack-x/
 *
 * You have a total of n yuan. Merchant has three merchandises and their prices are 150 yuan, 250 yuan and 350 yuan. And the number of these merchandises can be considered as infinite. After the purchase of goods need to be the remaining money to the businessman as a tip, finding the minimum tip for the merchant.

 Example
 Given: n = 900
 Return: 0
 */
public class BackpackX {
    /**
     * @param n: the money you have
     * @return: the minimum money you have to give
     */
    public int backPackX(int n) {
        if (n < 150) {
            return n;
        }
        if (n < 250) {
            return n - 150;
        }
        return (n - 250) % 50;
    }
}
