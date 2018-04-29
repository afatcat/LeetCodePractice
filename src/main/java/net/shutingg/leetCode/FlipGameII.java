package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/flip-game-ii/
 */
public class FlipGameII {
    /**
     * DFS
     *
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        char[] cs = s.toCharArray();
        boolean[] states = new boolean[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '+') {
                states[i] = true;
            } else {
                states[i] = false;
            }
        }

        return dfs(states);
    }

    private boolean dfs(boolean[] states) {
        int n = states.length;
        for (int i = 0; i < n - 1; i++) {
            if (states[i] && states[i + 1]) {
                states[i] = false;
                states[i + 1] = false;
                if (!dfs(states)) {
                    states[i] = true;
                    states[i + 1] = true;
                    return true;
                }
                states[i] = true;
                states[i + 1] = true;
            }
        }

        return false;
    }
}
