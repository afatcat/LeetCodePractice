package net.shutingg.systemDesign;

import java.util.*;

/**
 * Hash + List
 *
 * http://www.lintcode.com/en/problem/load-balancer/
 */
public class LoadBalancer {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public LoadBalancer() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        int i = list.size();
        map.put(server_id, i);
        list.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int i = map.get(server_id);
        int lastServer = list.get(list.size() - 1);
        list.set(i, lastServer);
        map.put(lastServer, i);
        map.remove(server_id);
        list.remove(list.size() - 1);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        if (list.size() == 0) {
            return -1;
        }
        int pl = rand.nextInt(list.size());
        return list.get(pl);
    }
}
