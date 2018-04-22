package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-81/problems/binary-trees-with-factors/
 *
 * Given an array of unique integers, each integer is strictly greater than 1.

 We make a binary tree using these integers and each number may be used for any number of times.

 Each non-leaf node's value should be equal to the product of the values of it's children.

 How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

 Example 1:

 Input: A = [2, 4]
 Output: 3
 Explanation: We can make these trees: [2], [4], [4, 2, 2]
 Example 2:

 Input: A = [2, 4, 5, 10]
 Output: 7
 Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class BinaryTreesWithFactors {
    private int mod = 1000000007;

    public int numFactoredBinaryTrees(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }


        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            indexMap.put(A[i], i);
        }
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int count = countCombination(i, map, indexMap, A) % mod;
            map.put(A[i], count);
            total = (total + count) % mod;
        }

        return total;
    }

    private int countCombination(int index, Map<Integer, Integer> map, Map<Integer, Integer> indexMap, int[] A) {
        List<Pair> pairList = productOf(index, A, indexMap);
        int count = 1;
        for (Pair pair : pairList) {
            if (pair.a == pair.b) {
                long countA = Long.valueOf(map.getOrDefault(pair.a, 1));
                count = (int) (count + countA * countA % mod) % mod;
            } else {
                long countA = Long.valueOf(map.getOrDefault(pair.a, 1));
                long countB = Long.valueOf(map.getOrDefault(pair.b, 1));
                count = (int) (count + (countA * countB % mod) * 2 % mod) % mod;
            }
        }

        return count;
    }

    private List<Pair> productOf(int index, int[] A, Map<Integer, Integer> indexMap) {
        List<Pair> list = new ArrayList<>();
        int seSqrtIndex = findSESqrtIndex(index, A);
        if (seSqrtIndex == -1) {
            return list;
        }
        if (A[seSqrtIndex] * A[seSqrtIndex] == A[index]) {
            list.add(new Pair(A[seSqrtIndex], A[seSqrtIndex]));
            seSqrtIndex--;
        }
        for (int i = seSqrtIndex; i >= 0; i--) {
            if (A[index] % A[i] != 0 || !indexMap.containsKey(A[index] / A[i])) {
                continue;
            }
            list.add(new Pair(A[i], A[index] / A[i]));
        }

        return list;
    }

    private int findSESqrtIndex(int index, int[] A) {
        int sqrt = (int) Math.sqrt(A[index]);
        return findSEIndex(0, index, sqrt, A);
    }

    private int findSEIndex(int st, int end, int target, int[] A) {
        if (A[st] == target) {
            return st;
        }
        if (A[end] == target) {
            return end;
        }

        while (st + 1 < end) {
            int mid = (end - st) / 2 + st;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                st = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] <= target) {
            return end;
        }
        if (A[st] <= target) {
            return st;
        }
        return -1;
    }

    class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
