package net.shutingg.leetCode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                int loc = stack.pop();
                int h = height[loc];
                int w = stack.isEmpty() ? i : i - stack.peek() -1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
}
