package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalTests {
    private InsertInterval insertInterval;

    @Before
    public void setup(){
        insertInterval = new InsertInterval();
    }
    @Test
    public void testInsert(){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        Interval newInterval = new Interval(5,7);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,7));
        expected.add(new Interval(8,10));
        expected.add(new Interval(15,18));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        newInterval = new Interval(4,9);

        expected = new ArrayList<>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,10));
        expected.add(new Interval(12,16));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));

        newInterval = new Interval(6,8);

        expected = new ArrayList<>();
        expected.add(new Interval(1,5));
        expected.add(new Interval(6,8));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));

        newInterval = new Interval(5,8);

        expected = new ArrayList<>();
        expected.add(new Interval(1,8));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));

        newInterval = new Interval(0,8);

        expected = new ArrayList<>();
        expected.add(new Interval(0,8));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(7,9));

        newInterval = new Interval(15,18);

        expected = new ArrayList<>();
        expected.add(new Interval(2,6));
        expected.add(new Interval(7,9));
        expected.add(new Interval(15,18));

        assertArrayEquals(expected.toArray(), insertInterval.insert(intervals, newInterval).toArray());
    }
}
