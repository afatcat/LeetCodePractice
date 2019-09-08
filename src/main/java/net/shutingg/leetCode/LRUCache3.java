package net.shutingg.leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {
    private LinkedHashMap<Integer, Integer> map;
    /*
    * @param capacity: An integer
    */
    public LRUCache3(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, (float)0.75, true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        map.put(key, value);
    }
}
