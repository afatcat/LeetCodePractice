package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/connecting-graph/
 * Union Find
 */
public class ConnectingGraph {
    int[] root;

    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
        root = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            root[rootA] = rootB;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
