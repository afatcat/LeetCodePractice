package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/lru-cache/
 *
 * LRU: Least Recently Used
 *  both get and set count as used
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DoubleNode> hash;
    private DoubleNode head;
    private DoubleNode tail;

    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new HashMap<>();
        head = new DoubleNode(-1, -1);
        tail = new DoubleNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }
        DoubleNode node = hash.get(key);
        if (capacity == 1) {
            return node.value;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;

        return node.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1) {
            DoubleNode node = hash.get(key);
            node.value = value;
        } else {
            DoubleNode node = new DoubleNode(key, value);
            hash.put(key, node);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;

            if (hash.size() > capacity) {
                hash.remove(head.next.key);
                head.next.next.prev = head;
                head.next = head.next.next;
            }
        }
    }

    class DoubleNode {
        DoubleNode next;
        DoubleNode prev;
        int key;
        int value;
        DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
