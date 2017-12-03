package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerfectSquaresTests {
    private PerfectSquares perfectSquares;

    @Before
    public void setup(){
        perfectSquares = new PerfectSquares();
    }

    @Test
    public void testNumSquares(){
        assertEquals(2, perfectSquares.numSquares(5));
        assertEquals(3, perfectSquares.numSquares(3));
        assertEquals(1, perfectSquares.numSquares(4));
        assertEquals(3, perfectSquares.numSquares(12));
        assertEquals(2, perfectSquares.numSquares(13));
        assertEquals(3, perfectSquares.numSquares(99));
    }
}
