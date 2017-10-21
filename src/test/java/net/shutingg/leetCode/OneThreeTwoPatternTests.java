package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OneThreeTwoPatternTests {
    private OneThreeTwoPattern oneThreeTwoPattern;

    @Before
    public void setup(){
         oneThreeTwoPattern = new OneThreeTwoPattern();
    }

    @Test
    public void testFind132pattern(){
        int nums[] = {1,2,3,4};
        assertFalse(oneThreeTwoPattern.find132pattern(nums));

        int nums2[] = {3, 1, 4, 2};
        assertTrue(oneThreeTwoPattern.find132pattern(nums2));

        int nums3[] = {-1, 3, 2, 0};
        assertTrue(oneThreeTwoPattern.find132pattern(nums3));

        int nums4[] = {-1, -2, 0, 2, 0};
        assertTrue(oneThreeTwoPattern.find132pattern(nums4));

        int nums5[] = {-1, -2, 0, 2, 5};
        assertFalse(oneThreeTwoPattern.find132pattern(nums5));

        int nums6[] = {};
        assertFalse(oneThreeTwoPattern.find132pattern(nums6));

        int nums7[] = {4, -3};
        assertFalse(oneThreeTwoPattern.find132pattern(nums7));

        int nums8[] = {4, -3, 9, 6};
        assertTrue(oneThreeTwoPattern.find132pattern(nums8));

        int nums9[] = {4, -3, 0, 6};
        assertFalse(oneThreeTwoPattern.find132pattern(nums9));

        //231 is false
        assertFalse(oneThreeTwoPattern.find132pattern(new int[]{1,0,1,-4,-3}));

        assertFalse(oneThreeTwoPattern.find132pattern(new int[]{5,6,1,2,4}));
    }
}
