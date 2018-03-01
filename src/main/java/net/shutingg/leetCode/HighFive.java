package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Record {
    public int id, score;
    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }
}

public class HighFive {
    /**
     * PriorityQueue
     *
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> res = new HashMap<>();
        if (results == null || results.length == 0) {
            return res;
        }
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Record r:results) {
            PriorityQueue<Integer> pq = map.get(r.id);
            if (pq == null) {
                pq = new PriorityQueue<>();
                map.put(r.id, pq);
            }
            if (pq.size() < 5) {
                pq.offer(r.score);
            } else {
                int top = pq.poll();
                top = Math.max(top, r.score);
                pq.offer(top);
            }
        }
        for (int key:map.keySet()) {
            double sum = 0;
            for (int score:map.get(key)) {
                sum += score;
            }
            res.put(key, sum / 5);
        }

        return res;
    }
}
