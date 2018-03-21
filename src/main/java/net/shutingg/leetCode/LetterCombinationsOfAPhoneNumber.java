package net.shutingg.leetCode;

import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(res, "", digits.toCharArray(), map, 0);
        return res;
    }

    private void dfs(List<String> res, String cur, char[] cs, Map<Character, String> map, int loc) {
        if (loc == cs.length) {
            res.add(cur);
            return;
        }

        String s = map.get(cs[loc]);
        for (Character c : s.toCharArray()) {
            dfs(res, cur + c, cs, map, loc + 1);
        }
    }
}
