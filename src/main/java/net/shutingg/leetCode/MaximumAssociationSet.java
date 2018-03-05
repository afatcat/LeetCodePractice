package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumAssociationSet {
    /**
     * @param listA: The relation between ListB's books
     * @param listB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] listA, String[] listB) {
        List<String> res = new ArrayList<>();
        if (listA == null || listA.length == 0 || listB == null || listB.length == 0 || listA.length != listB.length) {
            return res;
        }

        int n = listA.length;
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            uf.union(listA[i], listB[i]);
        }
        String root = null;
        int count = 0;
        for (String str : uf.counts.keySet()) {
            if (uf.counts.get(str) > count) {
                root = str;
                count = uf.counts.get(str);
            }
        }
        if (count > 0) {
            for (String str : uf.father.keySet()) {
                if (uf.find(str).equals(root)) {
                    res.add(str);
                }
            }
        }

        return res;
    }

    class UnionFind {
        Map<String, String> father = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        String find(String x) {
            if (father.get(x) == null || father.get(x).equals(x)) {
                if (counts.get(x) == null) {
                    counts.put(x, 1);
                }
                father.put(x, x);
                return x;
            }
            String parent = find(father.get(x));
            father.put(x, parent);
            return parent;
        }

        void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (rootA.equals(rootB)) {
                return;
            }
            int countA = counts.getOrDefault(rootA, 0);
            int countB = counts.getOrDefault(rootB, 0);
            if (countA < countB) {
                countB += countA;
                counts.put(rootB, countB);
                father.put(rootA, rootB);
            } else {
                countA += countB;
                counts.put(rootA, countA);
                father.put(rootB, rootA);
            }
        }
    }
}
