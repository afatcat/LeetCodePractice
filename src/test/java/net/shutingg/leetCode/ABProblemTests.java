package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ABProblemTests {
    private ABProblem abProblem;

    @Before
    public void setup() {
        abProblem = new ABProblem();
    }

    @Test
    public void testAplusb() {
        assertEquals(3, abProblem.aplusb(1, 2));
    }
}
