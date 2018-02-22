package net.shutingg.leetCode;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/expression-expand/
 */
public class ExpressionExpand {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] cs = s.toCharArray();
        Stack<Object> stack = new Stack();
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] <= '9' && cs[i] >= '0') {
                count = count * 10 + (cs[i] - '0');
            } else if (cs[i] == '[') {
                stack.push(count);
                count = 0;
            } else if (cs[i] == ']') {
                String str = makeString(stack);
                stack.push(str);
            } else {
                stack.push(cs[i]);
            }
        }
        return makeString(stack);
    }

    private String makeString(Stack<Object> stack) {
        Stack<Object> buffer = new Stack<>();
        while (!stack.isEmpty() && !(stack.peek() instanceof Integer)) {
            buffer.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        String result = sb.toString();
        if (!stack.isEmpty()) {
            int count = (Integer) stack.pop();
            if (count == 0) {
                result = "";
            }
            for (int i = 1; i < count; i++) {
                result += sb.toString();
            }
        }
        return result;
    }
}
