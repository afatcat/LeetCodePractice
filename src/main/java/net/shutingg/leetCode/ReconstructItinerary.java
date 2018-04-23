package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 */
public class ReconstructItinerary {
    public List<String> findItinerary2(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return res;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            graph.computeIfAbsent(tickets[i][0], k -> new PriorityQueue<>()).add(tickets[i][1]);
        }

        dfs(graph, "JFK", res);

        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String cur, List<String> res) {
        while (graph.get(cur) != null && !graph.get(cur).isEmpty()) {
            dfs(graph, graph.get(cur).poll(), res);
        }

        res.add(0, cur);
    }


    /**
     * Backtracking
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return res;
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            graph.putIfAbsent(tickets[i][0], new ArrayList<>());
            graph.get(tickets[i][0]).add(tickets[i][1]);
        }

        Map<String, List<Boolean>> visited = new HashMap<>();
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
            visited.put(key, new ArrayList<>());
            for (int i = 0; i < graph.get(key).size(); i++) {
                visited.get(key).add(false);
            }
        }

        res.add("JFK");
        dfs(graph, visited, "JFK", res, tickets.length + 1);

        return res;
    }

    private void dfs(Map<String, List<String>> graph, Map<String, List<Boolean>> visited, String cur, List<String> res, int n) {
        if (res.size() == n) {
            return;
        }

        List<String> list = graph.get(cur);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visited.get(cur).get(i)) {
                continue;
            }
            visited.get(cur).set(i, true);
            String next = list.get(i);
            res.add(next);
            dfs(graph, visited, next, res, n);
            if (res.size() == n) {
                return;
            }
            visited.get(cur).set(i, false);
            res.remove(res.size() - 1);
        }
    }
}
