package net.shutingg.leetCode;

import java.util.*;
public class LRUCache2 {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new Node(null, -1);
        tail = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node preNode = map.get(key);
        Node cur = preNode.next;
        if (preNode.next.next != null) {
            preNode.next = preNode.next.next;
            map.put(key, tail);
            tail.next = cur;
            tail = tail.next;
            map.put(preNode.next.key, preNode);
            cur.next = null;
        }

        return cur.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).next.val = value;
            return;
        }

        map.put(key, tail);
        Node cur = new Node(key, value);
        tail.next = cur;
        tail = tail.next;
        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            map.put(head.next.key, head);
        }
        System.out.println("key: " + key+", value: " + value);
        print(head);
    }

    private void print(Node node) {
        System.out.print(node.val + " -> ");
        if (node.next != null) {
            print(node.next);
        }
    }

    class Node {
        Node next;
        Integer key;
        Integer val;
        Node (Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }
}
