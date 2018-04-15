package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/design-phone-directory/description/
 *
 * HashMap + ArrayList
 */
public class DesignPhoneDirectory {
    Map<Integer, Boolean> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
        for (int i = 0; i < maxNumbers; i++) {
            list.add(i);
            map.put(i, true);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        int r = rand.nextInt(size);
        int num = list.get(r);
        map.put(num, false);
        if (r == size - 1) {
            list.remove(r);
        } else {
            int last = list.get(size - 1);
            list.set(r, last);
            list.remove(size - 1);
        }
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return map.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (map.get(number)) {
            return;
        }
        map.put(number, true);
        list.add(number);
    }
}
