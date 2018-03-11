package net.shutingg.leetCode;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/system-longest-file-path/
 */
public class SystemLongestFilePath {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] paths = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (String path : paths) {
            String[] strs = path.split("\t");
            int level = 0;
            while (strs[level].equals("")) {
                level++;
            }
            while (stack.size() > level) {
                stack.pop();
            }
            int pre = stack.isEmpty() ? 0 : stack.peek() + 1;
            int cur = pre + strs[level].length();
            if (strs[level].contains(".")) {
                if (cur > max) {
                    max = cur;
                }
            } else {
                stack.push(cur);
            }
        }

        return max;
    }
}
