package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/connecting-graph-ii/
 * Union Find
 */
public class ConnectingGraphII {
    private int[] root;
    private int[] rootCount;
    /*
    * @param n: An integer
    */
    public ConnectingGraphII(int n) {
        root = new int[n+1];
        rootCount = new int[n+1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            rootCount[i] = 1;
        }
    }

    public int find(int x) {
        if(root[x] == x) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rootCount[rootA] < rootCount[rootB]) {
            root[rootA] = rootB;
            rootCount[rootB] = rootCount[rootA] + rootCount[rootB];
        } else {
            root[rootB] = rootA;
            rootCount[rootA] = rootCount[rootA] + rootCount[rootB];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        int rootA = find(a);
        return rootCount[rootA];
    }
}
