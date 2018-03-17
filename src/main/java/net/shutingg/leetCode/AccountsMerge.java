package net.shutingg.leetCode;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }

        UnionFind uf = new UnionFind();
        for (List<String> list: accounts) {
            String name = list.get(0);
            if (name == null) {
                continue;
            }
            for (int i = 1; i < list.size(); i++) {
                uf.insert(list.get(i), name);
            }
        }

        for (List<String> list: accounts) {
            for (int i = 1; i < list.size() - 1; i++) {
                uf.union(uf.placeMap.get(list.get(i)), uf.placeMap.get(list.get(i + 1)));
            }
        }

        Map<Integer, List> listMap = new HashMap<>();
        for (int i = 0; i < uf.size; i++) {
            List<String> list;
            if (!listMap.containsKey(uf.find(i))) {
                list = new ArrayList<>();
                listMap.put(uf.find(i), list);
            } else {
                list = listMap.get(uf.find(i));
            }
            String email = uf.reverseMap.get(i);
            String name = uf.nameMap.get(email);
            list.add(email);
        }

        for (List list : listMap.values()) {
            Collections.sort(list);
            list.add(0, uf.nameMap.get(list.get(0)));
            res.add(list);
        }

        return res;
    }

    class UnionFind {
        Map<String, Integer> placeMap;
        Map<Integer, String> reverseMap;
        Map<String, String> nameMap;
        int[] father;
        int size;

        UnionFind() {
            placeMap = new HashMap<>();
            nameMap = new HashMap<>();
            reverseMap = new HashMap<>();
            father = new int[10000];
            size = 0;
        }

        void insert(String email, String name) {
            if (placeMap.containsKey(email)) {
                return;
            }
            placeMap.put(email, size);
            reverseMap.put(size, email);
            father[size] = size;
            size++;
            nameMap.put(email, name);
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }

            return father[x] = find(father[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            father[rootA] = rootB;
        }
    }
}
