package net.shutingg.leetCode;

import java.util.*;

/**
 * https://www.lintcode.com/en/problem/flip-game/
 */
public class FlipGame {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String t = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                result.add(t);
            }
        }

        return result;
    }
}
