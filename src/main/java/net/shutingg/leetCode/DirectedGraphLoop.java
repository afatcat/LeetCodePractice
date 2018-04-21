package net.shutingg.leetCode;

import java.util.*;

/**
 * Please judge whether there is a cycle in the directed graph with n vertices and m edges. The parameter is two int arrays. There is a directed edge from start[i] to end[i].

 Notice

 2 <= n <= 10^5
 1 <= m <= 4*10^5
 1 <= start[i], end[i] <= n

 Example
 Given start = [1],end = [2], return "False"。

 Explanation:
 There is only one edge 1->2, and do not form a cycle.
 Given start = [1,2,3],end = [2,3,1], return "True".

 Explanation:
 There is a cycle 1->2->3->1.
 */
public class DirectedGraphLoop {
    /**
     * @param start: The start points set
     * @param end: The end points set
     * @return: Return if the graph is cyclic
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        if (start == null || end == null || start.length != end.length) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            graph.putIfAbsent(start[i], new HashSet<>());
            graph.get(start[i]).add(end[i]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int u : graph.keySet()) {
            visited.add(u);
            if (dfs(graph, visited, u)) {
                return true;
            }
            visited.remove(u);
        }

        return false;
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int cur) {
        Set<Integer> set = graph.get(cur);
        if (set == null) {
            return false;
        }
        for (Integer i : set) {
            if (visited.contains(i)) {
                return true;
            }
            visited.add(i);
            if (dfs(graph, visited, i)) {
                return true;
            }
            visited.remove(i);
        }

        return false;
    }
}
