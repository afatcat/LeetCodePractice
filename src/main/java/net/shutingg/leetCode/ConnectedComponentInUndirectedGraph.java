package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/connected-component-in-undirected-graph/
 */
public class ConnectedComponentInUndirectedGraph {
    /**
     * Union Find
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        UnionFind uf = new UnionFind(nodes);
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (UndirectedGraphNode node : nodes) {
            int root = uf.find(node.label);
            List<Integer> list = map.get(root);
            if (list == null) {
                list = new ArrayList<>();
                map.put(root, list);
                result.add(list);
            }
            list.add(node.label);
        }

        return result;
    }

    class UnionFind {
        Map<Integer, Integer> parent;

        UnionFind(List<UndirectedGraphNode> nodes) {
            parent = new HashMap<>();
            for (UndirectedGraphNode node : nodes) {
                parent.put(node.label, node.label);
            }
        }

        int find(int x) {
            if (parent.get(x) == x) {
                return x;
            }
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return;
            }
            parent.put(parentA, parentB);
        }
    }
}
