package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sguan on 11/8/17.
 */
public class LargestNumberTests {
    private LargestNumber largestNumber;

    @Before
    public void setup(){
        largestNumber = new LargestNumber();
    }

    @Test
    public void testLargestNumber(){
        assertEquals("9534330", largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));

        assertEquals("990990330", largestNumber.largestNumber(new int[]{3, 30, 909, 90, 9}));

        assertEquals("9", largestNumber.largestNumber(new int[]{9}));

        assertEquals("", largestNumber.largestNumber(new int[]{}));

        assertEquals("0", largestNumber.largestNumber(new int[]{0,0}));
    }
}
