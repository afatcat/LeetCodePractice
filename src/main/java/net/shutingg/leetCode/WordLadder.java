package net.shutingg.leetCode;

import java.util.*;

/**
 * http://lintcode.com/en/problem/word-ladder/
 */
public class WordLadder {
    /**
     * Graph - BFS
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null) {
            return -1;
        }
        if (start.equals(end)) {
            return 1;
        }
        Map<String, Integer> distance = new HashMap<>();
        distance.put(start, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        dict.add(end);
        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String word : nextWords(current, dict)) {
                if (word.equals(end)) {
                    return distance.get(current) + 1;
                }
                if(distance.get(word) == null){
                    queue.offer(word);
                    distance.put(word, distance.get(current) +1);
                }
            }
        }
        return 0;
    }

    private List<String> nextWords(String word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < word.length(); j++) {
                if(i == word.charAt(j)) {
                    continue;
                }
                String nWord = replace(word, i, j);
                if(dict.contains(nWord)) {
                    list.add(nWord);
                }
            }
        }
        return list;
    }

    private String replace(String word, char c, int p) {
        char[] wc = word.toCharArray();
        wc[p] = c;
        return new String(wc);
    }
}
