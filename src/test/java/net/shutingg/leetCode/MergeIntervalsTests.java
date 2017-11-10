package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguan on 11/10/17.
 */
public class MergeIntervalsTests {
    private MergeIntervals mergeIntervals;

    @Before
    public void setup(){
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public void testMerge(){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,6));
        expected.add(new Interval(8,10));
        expected.add(new Interval(15,18));

        assertArrayEquals(expected.toArray(), mergeIntervals.merge(intervals).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(2,6));

        expected = new ArrayList<>();
        expected.add(new Interval(1,6));
        expected.add(new Interval(8,10));
        expected.add(new Interval(15,18));

        assertArrayEquals(expected.toArray(), mergeIntervals.merge(intervals).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,10));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(2,11));

        expected = new ArrayList<>();
        expected.add(new Interval(1,11));

        assertArrayEquals(expected.toArray(), mergeIntervals.merge(intervals).toArray());

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(4,5));

        expected = new ArrayList<>();
        expected.add(new Interval(1,5));

        assertArrayEquals(expected.toArray(), mergeIntervals.merge(intervals).toArray());
    }
}
