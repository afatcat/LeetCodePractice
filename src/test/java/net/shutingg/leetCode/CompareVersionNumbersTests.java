package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sguan on 11/2/17.
 */
public class CompareVersionNumbersTests {
    private CompareVersionNumbers compareVersionNumbers;
    @Before
    public void setup(){
        compareVersionNumbers = new CompareVersionNumbers();
    }

    @Test
    public void testCompareVersion(){
        //examples in question
        assertEquals(-1, compareVersionNumbers.compareVersion("0.1", "1.1"));
        assertEquals(-1, compareVersionNumbers.compareVersion("1.1", "1.2"));
        assertEquals(-1, compareVersionNumbers.compareVersion("1.2", "13.37"));

        //my tests
        assertEquals(0, compareVersionNumbers.compareVersion("1.1", "1.1"));
        assertEquals(0, compareVersionNumbers.compareVersion("0.1", "0.1"));

        assertEquals(1, compareVersionNumbers.compareVersion("0.1", "0"));
        assertEquals(1, compareVersionNumbers.compareVersion("3.1", "3"));
        assertEquals(1, compareVersionNumbers.compareVersion("3.21", "3.3"));

        //dangerous tests
        assertEquals(0, compareVersionNumbers.compareVersion("1.0", "1"));
        assertEquals(1, compareVersionNumbers.compareVersion("1.1", "1"));
    }
}
