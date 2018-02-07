package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    /**
     * UnionFind
     * (It doesn't need to be that complicated.)
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(num.length);
        for (int i = 0; i < num.length; i++) {
            uf.add(num[i]);
        }
        return uf.max;
    }

    private class UnionFind {
        Map<Integer, Integer> index = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int next;
        int[] root;
        int[] count;
        int max;

        UnionFind(int n){
            root = new int[n];
            count = new int[n];
            next = 0;
            max = 1;
        }

        void add(int i){
            if (visited.contains(i)) {
                return;
            }
            visited.add(i);
            index.put(i, next);
            root[next] = next;
            count[next] = 1;
            if (index.containsKey(i - 1)) {
                int pre = index.get(i - 1);
                connect(pre, next);
            }
            if (index.containsKey(i + 1)) {
                int post = index.get(i + 1);
                connect(post, next);
            }
            next++;
        }

        int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void connect(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (count[rootA] < count[rootB]) {
                root[rootA] = rootB;
                count[rootB] = count[rootA] + count[rootB];
                if (count[rootB] > max) {
                    max = count[rootB];
                }
            } else {
                root[rootB] = rootA;
                count[rootA] = count[rootA] + count[rootB];
                if (count[rootA] > max) {
                    max = count[rootA];
                }
            }

        }
    }
}
