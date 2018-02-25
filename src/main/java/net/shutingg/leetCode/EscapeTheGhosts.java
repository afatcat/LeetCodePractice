package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * This code may not pass.
 * The solution should be much simplier.
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if (target == null) {
            return false;
        }

        if (ghosts == null) {
            return true;
        }

        int minorM = 0;
        int minorN = 0;
        int m = 0;
        int n = 0;
        if (target[0] < 0) {
            minorM = target[0];
        } else {
            m = target[0];
        }
        if (target[1] < 0) {
            minorN = target[1];
        } else {
            n = target[1];
        }
        for (int i = 0; i < ghosts.length; i++) {
            if (target[0] < 0) {
                minorM = Math.min(ghosts[i][0], minorM);
            } else {
                m = Math.max(ghosts[i][0], m);
            }
            if (target[1] < 0) {
                minorN = Math.min(ghosts[i][1], minorN);
            } else {
                n = Math.max(ghosts[i][1], n);
            }
        }
        m = m - minorM + 1;
        n = n - minorN + 1;
        int offM = -minorM;
        int offN = -minorN;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <ghosts.length; k++) {
                    f[i][j] = Math.min(f[i][j], Math.abs(ghosts[k][0] - (i - offM)) + Math.abs(ghosts[k][1] - (j - offN)));
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(offM, offN, f, 0, target, visited, m, n, offM, offN);
    }

    boolean dfs(int i, int j, int[][] f, int cur, int[] target, boolean[][] visited, int m, int n, int offM, int offN) {
        if (cur >= f[i][j]) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if ((i - offM) == target[0] && (j - offN) == target[1]) {
            return true;
        }
        boolean res = false;
        //up
        if (i > 0) {
            res |= dfs(i - 1, j, f, cur + 1, target, visited, m, n, offM, offN);
        }
        //down
        if (i < m - 1) {
            res |= dfs(i + 1, j, f, cur + 1, target, visited, m, n, offM, offN);
        }
        //left
        if (j > 0) {
            res |= dfs(i, j - 1, f, cur + 1, target, visited, m, n, offM, offN);
        }
        //right
        if (j < n - 1) {
            res |= dfs(i, j + 1, f, cur + 1, target, visited, m, n, offM, offN);
        }
        return res;
    }
}
