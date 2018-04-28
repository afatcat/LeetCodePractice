package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/bus-routes/description/
 */
public class BusRoutes {
    /**
     * BFS
     * Record bus route to reduce time
     *
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        if (routes == null || routes.length == 0) {
            return -1;
        }
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                routeMap.putIfAbsent(routes[i][j], new HashSet<>());
                routeMap.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        Set<Integer> usedRoutes = new HashSet<>();

        visited.put(S, 0);
        queue.offer(S);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (int line : routeMap.get(u)) {
                    if (usedRoutes.contains(line)) {
                        continue;
                    }

                    for (int v : routes[line]) {
                        if (v == T) {
                            return step;
                        }
                        if (visited.containsKey(v)) {
                            continue;
                        }

                        visited.put(v, step);
                        queue.offer(v);
                    }
                }
            }
        }

        return -1;
    }
}
