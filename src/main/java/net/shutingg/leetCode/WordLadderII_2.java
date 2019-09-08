package net.shutingg.leetCode;

import java.util.*;

public class WordLadderII_2 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return result;
        }

        Map<String, Integer> distances = new HashMap<>();
        distances.put(end, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        int d = 0;
        dict.add(start);
        dict.add(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            d++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String w: dict) {
                    if (!distances.containsKey(w) && isNeighbor(word, w)) {
                        distances.put(w, d);
                        queue.offer(w);
                    }
                }
            }
        }

        for (String word: distances.keySet()) {
            System.out.println(word + " " + distances.get(word));
        }

        List<String> list = new ArrayList<>();
        list.add(start);

        dfs(result, list, start, end, dict, distances);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, String current, String end, Set<String> dict, Map<String, Integer> distances) {
        if (isNeighbor(current,end)) {
            List<String> newList = new ArrayList<>(list);
            newList.add(end);
            result.add(newList);
            return;
        }

        int currentDistance = distances.get(current);
        for (String word: distances.keySet()) {
            if (distances.get(word) != currentDistance - 1) {
                continue;
            }
            if (!isNeighbor(current, word)) {
                continue;
            }
            list.add(word);
            dfs(result, list, word, end, dict, distances);
            list.remove(list.size() - 1);
        }
    }

    private boolean isNeighbor(String current, String word) {
        int diffCount = 0;
        if (current.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        if (diffCount == 1) {
            return true;
        }
        return false;
    }
}
