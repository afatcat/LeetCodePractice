package net.shutingg.leetCode;

import java.util.*;

public class WordBreakII {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        map.put("", new ArrayList<>());
        map.get("").add("");
        return dfs(s, wordDict, map);
    }

    private List<String> dfs (String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (wordDict.contains(s1)) {
                List<String> lS2 = dfs(s2, wordDict, map);
                for (String w2 : lS2) {
                    if ("".equals(w2)) {
                        res.add(s1);
                    } else {
                        res.add(s1 + " " + w2);
                    }
                }
            }
        }

        map.put(s, res);
        return res;
    }
}
