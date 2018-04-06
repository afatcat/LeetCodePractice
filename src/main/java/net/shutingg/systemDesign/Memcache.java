package net.shutingg.systemDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/memcache/
 *
 * System Design
 */
public class Memcache {
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> live;

    public Memcache() {
        map = new HashMap<>();
        live = new HashMap<>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        System.out.println("get key: "+ key);
        if (map.containsKey(key)) {
            if (live.containsKey(key)) {
                System.out.println("key live " + live.get(key));
                if (curtTime < live.get(key)) {
                    return map.get(key);
                } else {
                    map.remove(key);
                    live.remove(key);
                    return Integer.MAX_VALUE;
                }
            } else {
                return map.get(key);
            }
        }

        return Integer.MAX_VALUE;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        map.put(key, value);
        if (ttl > 0) {
            live.put(key, curtTime + ttl);
        } else {
            live.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        map.remove(key);
        live.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        }

        if (!live.containsKey(key) || curtTime < live.get(key)) {
            map.put(key, map.get(key) + delta);
            return map.get(key);
        }

        map.remove(key);
        live.remove(key);
        return Integer.MAX_VALUE;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        return incr(curtTime, key, -delta);
    }
}
