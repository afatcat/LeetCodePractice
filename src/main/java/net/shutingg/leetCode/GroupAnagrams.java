package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/group-anagrams/
 */
public class GroupAnagrams {
    /**
     * Hash
     *
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortStr = new String(c);
            map.putIfAbsent(sortStr, new ArrayList<>());
            map.get(sortStr).add(str);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }
}
