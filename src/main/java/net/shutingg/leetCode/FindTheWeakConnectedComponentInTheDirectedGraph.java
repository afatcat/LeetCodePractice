package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 */
public class FindTheWeakConnectedComponentInTheDirectedGraph {
    /**
     * UnionFind
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }

        UnionFind uf = new UnionFind(nodes);
        for (DirectedGraphNode node:nodes) {
            for (DirectedGraphNode neighbor:node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            int index = uf.index.get(nodes.get(i).label);
            int rootIndex = uf.find(index);
            List<Integer> list = map.get(rootIndex);
            if (list == null) {
                list = new ArrayList<>();
                map.put(rootIndex, list);
                result.add(list);
            }
            list.add(nodes.get(i).label);
        }

        return result;
    }

    class UnionFind {
        int[] root;
        Map<Integer, Integer> index = new HashMap<>();

        UnionFind(ArrayList<DirectedGraphNode> nodes) {
            root = new int[nodes.size()];
            for (int i = 0; i < nodes.size(); i++) {
                index.put(nodes.get(i).label, i);
                root[i] = i;
            }
        }

        int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int indexX = index.get(x);
            int indexY = index.get(y);
            int rootX = find(indexX);
            int rootY = find(indexY);
            if (rootX == rootY) {
                return;
            }
            root[rootX] = rootY;
        }
    }
}
