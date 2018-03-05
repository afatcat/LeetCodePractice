package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/buy-fruits/
 */
public class BuyFruits {
    /**
     * @param codeList: The codeList
     * @param shoppingCart: The shoppingCart
     * @return: The answer
     */
    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.size() == 0) {
            return 1;
        }
        if (shoppingCart == null || shoppingCart.size() == 0) {
            return 0;
        }

        List<String> codes = new ArrayList<>();
        for (List<String> list : codeList) {
            for (String item : list) {
                codes.add(item);
            }
        }

        int m = codes.size();
        int n = shoppingCart.size();
        if (m > n) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int k = 1;
        while (i < m && j < n) {
            if (codes.get(i).equals("anything") || codes.get(i).equals(shoppingCart.get(j))) {
                i++;
                j++;
            } else {
                i = 0;
                j = k;
                k++;
            }
        }
        if (i < m) {
            return 0;
        }
        return 1;
    }
}
