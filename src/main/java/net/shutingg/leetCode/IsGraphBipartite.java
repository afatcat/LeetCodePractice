package net.shutingg.leetCode;

import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }

        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] >= 0) {
                continue;
            }
            if(!dfs(graph, colors, 0, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int cur) {
        if (colors[cur] != -1) {
            if (colors[cur] == color) {
                return true;
            } else {
                return false;
            }
        }

        colors[cur] = color;
        for (int j = 0; j < graph[cur].length; j++) {
            if (!dfs(graph, colors, 1 - color, graph[cur][j])) {
                return false;
            }
        }

        return true;
    }
}
