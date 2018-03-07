package net.shutingg.leetCode;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;

    public InsertDeleteGetRandomO1() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        int loc = list.size() - 1;
        map.put(val, loc);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        int last = list.size() - 1;
        int lastVal = list.get(last);
        list.set(loc, list.get(last));
        map.put(lastVal, loc);
        list.remove(last);
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}
