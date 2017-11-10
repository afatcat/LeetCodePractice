package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sguan on 11/9/17.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof Interval){
            return start == ((Interval) obj).start && end ==((Interval) obj).end;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size()==0){
            return result;
        }
        //sort intervals by start
        List<Interval> sortIntervals = intervals.stream().sorted((Interval i1, Interval i2) -> i1.start - i2.start).collect(Collectors.toList());

        //merge if end of first overlaps with start of second
        Interval prev = sortIntervals.get(0);
        result.add(prev);
        int r = 0;
        for(int i=1; i<sortIntervals.size(); i++){
            Interval item = sortIntervals.get(i);
            if(item.start <= prev.end){
                Interval merged = new Interval(prev.start, item.end>prev.end? item.end:prev.end);
                result.remove(r);
                result.add(merged);
                prev = merged;
            }else{
                result.add(item);
                prev = item;
                r++;
            }
        }

        return result;
    }
}
