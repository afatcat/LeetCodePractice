package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/implement-stack-by-two-queues/
 */
public class ImplementStackByTwoQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            queue1.poll();
        } else {
            while(queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            queue2.poll();
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int result = queue1.poll();
            queue2.offer(result);
            return result;
        } else {
            while(queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            int result = queue2.poll();
            queue1.offer(result);
            return result;
        }
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
