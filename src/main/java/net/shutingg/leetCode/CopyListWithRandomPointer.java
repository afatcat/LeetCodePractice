package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }

/**
 * http://lintcode.com/en/problem/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    /**
     * Graph - BFS
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        Queue<RandomListNode> queue = new LinkedList<>();
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        //copy nodes
        queue.offer(head);
        while (!queue.isEmpty()) {
            RandomListNode cur = queue.poll();
            if(map.get(cur) != null) {
                continue;
            }
            RandomListNode copy = new RandomListNode(cur.label);
            map.put(cur, copy);
            if(cur.next != null) {
                queue.offer(cur.next);
            }
            if(cur.random != null) {
                queue.offer(cur.random);
            }
        }

        //copy links
        for (RandomListNode key:map.keySet()) {
            RandomListNode copy = map.get(key);
            copy.next = map.get(key.next);
            copy.random = map.get(key.random);
        }

        return map.get(head);
    }
}
