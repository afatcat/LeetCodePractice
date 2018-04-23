package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/description/
 */
public class StrobogrammaticNumberII {
    private Set<Character> sameSet;
    private Map<Character, Character> map;
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        sameSet = new HashSet<>();
        sameSet.add('0');
        sameSet.add('1');
        sameSet.add('8');

        dfs(n, res, "");

        return res;
    }

    private void dfs(int n, List<String> res, String cur) {
        if (cur.length() == n / 2) {
            if (n % 2 == 0) {
                res.add(cur + flipString(cur));
            } else {
                String reverse = flipString(cur);
                for (Character c : sameSet) {
                    res.add(cur + c + reverse);
                }
            }
            return;
        }

        for (Character key : map.keySet()) {
            if (cur.length() == 0 && key == '0') {
                continue;
            }
            dfs(n, res, cur + key);
        }
    }

    private String flipString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(map.get(s.charAt(i)));
        }

        return sb.toString();
    }
}
