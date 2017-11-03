package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by sguan on 11/3/17.
 */
public class TriangleTests {
    private Triangle triangle;

    private List<List<Integer>> input;
    private List<List<Integer>> input2;
    @Before
    public void setup(){
        triangle = new Triangle();

        input = new ArrayList<>();
        input.add(Arrays.asList(new Integer[]{2}));
        input.add(Arrays.asList(new Integer[]{3,4}));
        input.add(Arrays.asList(new Integer[]{6,5,7}));
        input.add(Arrays.asList(new Integer[]{4,1,8,3}));

        input2 = new ArrayList<>();
        input2.add(Arrays.asList(new Integer[]{1}));
        input2.add(Arrays.asList(new Integer[]{10,0}));
        input2.add(Arrays.asList(new Integer[]{100,101,10}));
        input2.add(Arrays.asList(new Integer[]{0,1,1000,1001}));
    }

    @Test
    public void testMinimumTotal(){
        assertEquals(11, triangle.minimumTotal(input));
        assertEquals(103, triangle.minimumTotal(input2));
    }
}
