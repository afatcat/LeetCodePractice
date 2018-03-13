package net.shutingg.systemDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/consistent-hashing/
 */
public class ConsistentHashing {
    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(359);
        list1.add(1);
        res.add(list1);

        for (int i = 2; i <= n; i++) {
            insertMachine(res, i);
        }

        return res;
    }

    private void insertMachine(List<List<Integer>> lists, int n) {
        int pl = 0;
        int interval = 0;
        int i = 0;
        int machine = Integer.MAX_VALUE;
        for (List<Integer> list : lists) {
            int space = list.get(1) - list.get(0);
            if (space > interval) {
                pl = i;
                interval = space;
                machine = list.get(2);
            } else if (space == interval && machine > list.get(2)) {
                pl = i;
                machine = list.get(2);
            }
            i++;
        }

        List<Integer> orig = lists.get(pl);
        List<Integer> adding = new ArrayList<>();
        int left = orig.get(0);
        int right = orig.get(1);
        orig.set(1, (left + right) / 2);
        adding.add((left + right) / 2 + 1);
        adding.add(right);
        adding.add(n);
        lists.add(pl + 1, adding);
    }
}
