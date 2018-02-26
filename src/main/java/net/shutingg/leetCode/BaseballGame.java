package net.shutingg.leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/baseball-game/description/
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String s:ops) {
            if ("+".equals(s)) {
                int plus = 0;
                if(!stack.isEmpty()) {
                    int last = stack.pop();
                    plus += last;
                    if (!stack.isEmpty()) {
                        int second = stack.pop();
                        plus += second;
                        stack.push(second);
                    }
                    stack.push(last);
                }
                stack.push(plus);
                sum += plus;
            } else if("D".equals(s)) {
                int dbl = 0;
                if (!stack.isEmpty()) {
                    dbl = stack.peek() * 2;
                }
                stack.push(dbl);
                sum += dbl;
            } else if ("C".equals(s)) {
                int clear = 0;
                if (!stack.isEmpty()) {
                    clear = stack.pop();
                }
                sum -= clear;
            } else {
                int value = Integer.valueOf(s);
                stack.push(value);
                sum += value;
            }
        }
        return sum;
    }
}
