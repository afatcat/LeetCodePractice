package net.shutingg.leetCode;

import java.util.*;

/**
 * We are given head, the head node of a linked list containing unique integer values.

 We are also given the list G, a subset of the values in the linked list.

 Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

 Example 1:

 Input:
 head: 0->1->2->3
 G = [0, 1, 3]
 Output: 2
 Explanation:
 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 Example 2:

 Input:
 head: 0->1->2->3->4
 G = [0, 3, 1, 4]
 Output: 2
 Explanation:
 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 Note:

 If N is the length of the linked list given by head, 1 <= N <= 10000.
 The value of each node in the linked list will be in the range [0, N - 1].
 1 <= G.length <= 10000.
 G is a subset of all values in the linked list.
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(10001);

        Map<Integer, Integer> locations = new HashMap<>();
        Map<Integer, Integer> reverse = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        int loc = 0;
        while (cur != null) {
            locations.put(cur.val, loc);
            reverse.put(loc, cur.val);
            loc++;
            cur = cur.next;
        }
        for (int i = 0; i < G.length; i++) {
            loc = locations.get(G[i]);
            set.add(G[i]);
            if (reverse.containsKey(loc - 1) && set.contains(reverse.get(loc - 1))) {
                uf.union(reverse.get(loc - 1), G[i]);
            }
            if (reverse.containsKey(loc + 1) && set.contains(reverse.get(loc + 1))) {
                uf.union(reverse.get(loc + 1), G[i]);
            }
        }

        Set<Integer> components = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            components.add(uf.find(G[i]));
        }

        return components.size();
    }

    class UnionFind {
        int[] fathers;
        int[] counts;

        UnionFind(int size) {
            fathers = new int[size];
            counts = new int[size];
            for (int i = 0; i < size; i++) {
                fathers[i] = i;
                counts[i] = 1;
            }
        }

        int find(int a) {
            if (fathers[a] == a) {
                return a;
            }
            fathers[a] = find(fathers[a]);
            return fathers[a];
        }

        int findCount(int x) {
            int rootX = find(x);
            return counts[rootX];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (counts[rootA] < counts[rootB]) {
                fathers[rootA] = rootB;
                counts[rootB] += counts[rootA];
            } else {
                fathers[rootB] = rootA;
                counts[rootA] += counts[rootB];
            }
        }
    }
}
