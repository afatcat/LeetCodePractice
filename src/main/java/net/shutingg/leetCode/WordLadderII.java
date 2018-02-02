package net.shutingg.leetCode;

import java.util.*;

/**
 * http://lintcode.com/en/problem/word-ladder-ii/
 */
public class WordLadderII {
    /**
     * Graph BFS + DFS
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null) {
            return null;
        }

        List<List<String>> result = new ArrayList<>();
        if(start.equals(end)){
            List<String> list = new ArrayList<>();
            list.add(start);
            result.add(list);
            return result;
        }

        //construct graph
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> pred = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        distance.put(start, 1);

        int endDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (visited.contains(current)) {
                continue;
            }
            int curDist = distance.get(current);
            if (curDist > endDist) {
                continue;
            }
            List<String> words = nextWords(current, dict);
            for (String word : words) {
                Integer wordDist = distance.get(word);
                //if word before current
                if (wordDist != null && wordDist <= curDist) {
                    continue;
                }
                wordDist = curDist + 1;
                distance.put(word, wordDist);
                List<String> previous = pred.get(word);
                if (previous == null) {
                    previous = new ArrayList<>();
                    pred.put(word, previous);
                }
                previous.add(current);
                if (word.equals(end)) {
                    if(endDist > wordDist){
                        endDist = wordDist;
                    }
                    break;
                }
                queue.offer(word);
            }
            visited.add(current);
        }

        //construct paths
        if (pred.get(end) == null) {
            return result;
        }
        List<String> list = new ArrayList<>();
        list.add(end);
        dfs(result, list, end, pred, start);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, String current, Map<String, List<String>> pred, String target) {
        if (target.equals(current)) {
            result.add(new ArrayList<>(list));
            return;
        }
        List<String> previous = pred.get(current);
        for (String p:previous) {
            list.add(0, p);
            dfs(result, list, p, pred, target);
            list.remove(0);
        }
    }

    private List<String> nextWords(String word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < word.length(); i++) {
                if(c == word.charAt(i)){
                    continue;
                }
                String nWord = replace(word, i, c);
                if (dict.contains(nWord)) {
                    list.add(nWord);
                }
            }
        }
        return list;
    }

    private String replace(String word, int p, char c) {
        char[] wc = word.toCharArray();
        wc[p] = c;
        return new String(wc);
    }
}
