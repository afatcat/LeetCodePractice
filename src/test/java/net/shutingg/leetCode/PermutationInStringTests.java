package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationInStringTests {
    private PermutationInString permutationInString;
    @Before
    public void setup() {
        permutationInString = new PermutationInString();
    }

    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "cba";
        assertTrue(permutationInString.checkInclusion(s1, s2));
    }
}
