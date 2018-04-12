package net.shutingg.systemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeartBeat {
    private Map<String, Integer> slaveMap;
    private int k;

    public HeartBeat() {
        slaveMap = new HashMap<>();
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    public void initialize(List<String> slaves_ip_list, int k) {
        for (String slave : slaves_ip_list) {
            slaveMap.put(slave, 0);
        }

        this.k = k;
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    public void ping(int timestamp, String slave_ip) {
        if (slaveMap.containsKey(slave_ip)) {
            slaveMap.put(slave_ip, timestamp);
        }
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    public List<String> getDiedSlaves(int timestamp) {
        List<String> res = new ArrayList<>();
        for (String key : slaveMap.keySet()) {
            if (timestamp - slaveMap.get(key) >= 2 * k) {
                res.add(key);
            }
        }

        return res;
    }
}
