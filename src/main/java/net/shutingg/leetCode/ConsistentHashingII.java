package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class ConsistentHashingII {
    private static int N;
    private static int K;
    private static TreeMap<Integer, Integer> machines;
    private static Random rand;

    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    public static ConsistentHashingII create(int n, int k) {
        N = n;
        K = k;
        machines = new TreeMap<>();
        rand = new Random();
        return new ConsistentHashingII();
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int shard = rand.nextInt(N);
            while (machines.containsKey(shard)) {
                shard = rand.nextInt(N);
            }
            machines.put(shard, machine_id);
            list.add(shard);
        }

        return list;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        Integer upper = machines.ceilingKey(hashcode);
        if (upper == null) {
            upper = machines.ceilingKey(0);
        }
        return machines.get(upper);
    }
}
