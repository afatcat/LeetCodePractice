package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 * http://www.lintcode.com/en/problem/insert-interval/
 */
public class InsertInterval {
    /**
     * 2nd attempt, simplified a bit
     *
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        if (intervals == null) {
            List<Interval> list = new ArrayList<>();
            list.add(newInterval);
            return list;
        }

        int i = 0;
        while (i < intervals.size()) {
            if (intervals.get(i).start < newInterval.start) {
                i++;
                continue;
            }

            break;
        }

        int j = i;
        while (j < intervals.size()) {
            if (newInterval.end >= intervals.get(j).start) {
                newInterval.end = Math.max(newInterval.end, intervals.get(j).end);
                j++;
                continue;
            }

            break;
        }

        for (int k = i; k < j; k++) {
            intervals.remove(i);
        }

        if (i > 0) {
            if (intervals.get(i - 1).end >= newInterval.start) {
                newInterval.start = intervals.get(i - 1).start;
                newInterval.end = Math.max(intervals.get(i - 1).end, newInterval.end);
                intervals.remove(i - 1);
                i--;
            }
        }

        intervals.add(i, newInterval);
        return intervals;
    }



    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> result = new LinkedList<>();
        if(intervals == null || intervals.size()==0){
            result.add(newInterval);
            return result;
        }
        if(newInterval == null){
            return intervals;
        }

        Interval[] array = intervals.toArray(new Interval[]{});
        int startLoc = 0;
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        if(array[0].start <= newInterval.start){
            if(array[0].end >= newInterval.end){
                newEnd = array[0].end;
                newStart = array[0].start;
            }else if(newInterval.start<= array[0].end){
                newStart = array[0].start;
            }else if(array.length ==1){
                result.add(array[0]);
            }
            //find startLoc
            for(int i=1; i<array.length; i++){
                if(newStart<array[i].start){
                    startLoc = i;
                    break;
                }else{
                    startLoc = i+1;
                }
            }
        }

        for(int i=0; i<startLoc; i++){
            if(newStart > array[i].end){
                result.add(array[i]);
            }else{
                newEnd = Math.max(newEnd, array[i].end);
                newStart = Math.min(newStart, array[i].start);
            }
        }

        result.add(new Interval(newStart, newEnd));

        for(int i=startLoc; i<array.length; i++){
            if(newEnd < array[i].start){
                result.add(array[i]);
            }else{
                newEnd = Math.max(newEnd, array[i].end);
                result.removeLast();
                result.add(new Interval(newStart, newEnd));
            }
        }

        return result;
    }
}
