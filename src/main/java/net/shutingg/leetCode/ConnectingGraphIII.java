package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/connecting-graph-iii/
 * Union Find
 */
public class ConnectingGraphIII {
    int[] root;
    int count;

    /*
    * @param n: An integer
    */
    public ConnectingGraphIII(int n) {
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
        count = n;
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
        root[rootA] = rootB;
        count--;
    }

    /*
     * @return: An integer
     */
    public int query() {
        return count;
    }
}
