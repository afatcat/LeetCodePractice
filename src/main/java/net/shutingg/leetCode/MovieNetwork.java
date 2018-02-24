package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * http://www.lintcode.com/en/problem/movie-network/
 * Amazon OA
 */
public class MovieNetwork {
    /**
     * UnionFind
     *
     * @param rating: the rating of the movies
     * @param G:      the realtionship of movies
     * @param S:      the begin movie
     * @param K:      top K rating
     * @return: the top k largest rating moive which contact with S
     */
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        if (rating == null || rating.length == 0 || G == null || G.length == 0 || K == 0) {
            return new int[0];
        }

        UnionFind uf = new UnionFind(rating.length);
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                uf.union(i, j);
            }
        }
        int root = uf.find(S);
        int count = uf.count[root];
        Rating[] rates = new Rating[count - 1];
        int j = 0;
        for (int i = 0; i < rating.length; i++) {
            if (uf.find(i) == root && i != S) {
                rates[j] = new Rating(i, rating[i]);
                j++;
            }
        }
        Arrays.sort(rates, (a, b) -> b.rate - a.rate);
        int[] res = new int[K];
        for (int i = 0; i < K; i++) {
            res[i] = rates[i].index;
        }
        return res;
    }

    class Rating {
        int index;
        int rate;

        Rating(int index, int rate) {
            this.index = index;
            this.rate = rate;
        }
    }

    class UnionFind {
        int[] parent;
        int[] count;

        UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (count[rootA] > count[rootB]) {
                    parent[rootA] = rootB;
                    count[rootB] += count[rootA];
                } else {
                    parent[rootB] = rootA;
                    count[rootA] += count[rootB];
                }
            }
        }
    }
}
