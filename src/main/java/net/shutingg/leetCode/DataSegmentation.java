package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/data-segmentation/
 *
 * Given a string str, we need to extract the symbols and words of the string in order.

 Notice

 The length of str does not exceed 10000.
 The given str contains only lowercase letters, symbols, and spaces.

 Example
 Given str = "(hi (i am)bye)"，return ["(","hi","(","i","am",")","bye",")"].

 Explanation:
 Separate symbols and words.
 Given str = "#ok yes"，return ["#","ok","yes"]。

 Explanation:
 Separate symbols and words.
 Given str = "##s"，return ["#","#","s"]。

 Explanation:
 Separate symbols and words.
 */
public class DataSegmentation {
    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        if (str == null || str.length() == 0) {
            return new String[0];
        }

        List<String> res = new ArrayList<>();
        char[] cs = str.toCharArray();
        int n = cs.length;
        String word = "";
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(cs[i])) {
                word += cs[i];
            } else if (cs[i] == ' ') {
                if (word.length() > 0 ) {
                    res.add(word);
                    word = "";
                }
            } else {
                if (word.length() > 0 ) {
                    res.add(word);
                    word = "";
                }
                res.add("" + cs[i]);
            }
        }
        if (word.length() > 0) {
            res.add(word);
        }
        String[] result = new String[res.size()];
        res.toArray(result);
        return result;
    }
}
