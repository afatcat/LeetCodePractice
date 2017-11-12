package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
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
