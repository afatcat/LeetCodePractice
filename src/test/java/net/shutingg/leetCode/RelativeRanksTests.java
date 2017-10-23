package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RelativeRanksTests {
    private RelativeRanks relativeRanks;
    @Before
    public void setup(){
        relativeRanks = new RelativeRanks();
    }

    @Test
    public void testFindRelativeRanks(){
        int[] nums={5, 4, 3, 2, 1};
        String[] results = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        assertArrayEquals(results, relativeRanks.findRelativeRanks(nums));

        assertArrayEquals(new String[]{"Gold Medal"}, relativeRanks.findRelativeRanks(new int[]{3}));
    }
}
