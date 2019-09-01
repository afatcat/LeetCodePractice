package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSumDataStructureDesignTests {
    private TwoSumDataStructureDesign twoSumDataStructureDesign;
    @Before
    public void setup() {
        twoSumDataStructureDesign = new TwoSumDataStructureDesign();
    }

    @Test
    public void test1() {
        twoSumDataStructureDesign.add(2);
        twoSumDataStructureDesign.add(3);
        assertFalse(twoSumDataStructureDesign.find(4));
    }

    @Test
    public void test2() {
        twoSumDataStructureDesign.add(2);
        twoSumDataStructureDesign.add(2);
        assertTrue(twoSumDataStructureDesign.find(4));
        assertFalse(twoSumDataStructureDesign.find(2));
        assertFalse(twoSumDataStructureDesign.find(1));
        assertFalse(twoSumDataStructureDesign.find(6));
    }
}
