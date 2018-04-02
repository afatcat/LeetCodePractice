package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/sequence-reconstruction/
 */
public class SequenceReconstruction {
    /**
     * Topological Sorting
     * When Topological Sorting is unique, there should only one element in the queue at the same time.
     *
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null || seqs.length == 0) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length == 0) {
                continue;
            }
            graph.putIfAbsent(seqs[i][0], new HashSet<>());
            for (int j = 0; j < seqs[i].length - 1; j++) {
                graph.putIfAbsent(seqs[i][j], new HashSet<>());
                graph.get(seqs[i][j]).add(seqs[i][j + 1]);
            }
        }

        for (int k : graph.keySet()) {
            for (int v : graph.get(k)) {
                inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer k : graph.keySet()) {
            if (!inDegree.containsKey(k)) {
                queue.offer(k);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            if (queue.size() >= 2) {
                return false;
            }
            int k = queue.poll();
            if (i >= org.length) {
                return false;
            }
            if (org[i] != k) {
                return false;
            }
            i++;

            if (!graph.containsKey(k)) {
                continue;
            }
            for (Integer v : graph.get(k)) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        if (i != org.length) {
            return false;
        }

        return true;
    }
}
