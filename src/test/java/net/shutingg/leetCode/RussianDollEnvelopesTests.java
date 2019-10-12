package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RussianDollEnvelopesTests {
    private RussianDollEnvelopes russianDollEnvelopes;
    @Before
    public void setup() {
        russianDollEnvelopes = new RussianDollEnvelopes();
    }

    @Test
    public void testExample1() {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        assertEquals(3, russianDollEnvelopes.maxEnvelopes(envelopes));
    }

    @Test
    public void testExample2() {
        int[][] envelopes = {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        assertEquals(5, russianDollEnvelopes.maxEnvelopes(envelopes));
    }
}
